package edu.java.scrapper.service.jooq;

import edu.java.dto.request.AddLinkRequest;
import edu.java.dto.request.RemoveLinkRequest;
import edu.java.dto.response.LinkResponse;
import edu.java.dto.response.ListLinksResponse;
import edu.java.scrapper.annotation.TransactionalService;
import edu.java.scrapper.entity.Link;
import edu.java.scrapper.exception.LinkIsAlreadyTrackedException;
import edu.java.scrapper.exception.LinkIsNotTrackedException;
import edu.java.scrapper.repository.jooq.JooqLinkRepository;
import edu.java.scrapper.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;
import java.net.URI;
import java.time.Duration;
import java.util.Collection;
import java.util.Optional;

@TransactionalService
@RequiredArgsConstructor
public class JooqLinkService implements LinkService {
    private final JooqLinkRepository linkRepository;
    @Override
    public ListLinksResponse findAllById(Long id) {
        Collection<Link> links = linkRepository.findByChatId(id);
        return new ListLinksResponse(
            links.stream()
                .map(link -> new LinkResponse(link.getId(), URI.create(link.getUri())))
                .toList(),
            links.size()
        );
    }

    @Override
    @Transactional
    public LinkResponse add(Long id, AddLinkRequest req) {
        Link link;
        URI url = req.link();
        Optional<Link> found = linkRepository.findByUrl(url);

        link = found.orElseGet(() -> linkRepository.save(
            Link.fromUrl(url)
        ));

        try {
            linkRepository.connectLink(id, link.getId());
        } catch (DuplicateKeyException ignored) {
            throw new LinkIsAlreadyTrackedException(url, id);
        }
        return new LinkResponse(link.getId(), url);
    }

    @Override
    @Transactional
    public LinkResponse delete(Long id, RemoveLinkRequest req) {
        URI url = req.link();
        Optional<Link> link = linkRepository.findByUrl(url);

        if (link.isPresent()) {
            linkRepository.removeLink(id, link.get().getId());

            return new LinkResponse(link.get().getId(), url);
        } else {
            throw new LinkIsNotTrackedException(url, id);
        }
    }

    @Override
    @Transactional
    public void updateLink(Link link) {
        linkRepository.update(link);
    }

    @Override
    public Collection<Link> findAllWithDelay(Duration delay) {
        return linkRepository.findAllWithInterval(delay);
    }
}