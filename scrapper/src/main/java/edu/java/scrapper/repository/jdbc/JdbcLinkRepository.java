package edu.java.scrapper.repository.jdbc;

import edu.java.scrapper.entity.Link;
import edu.java.scrapper.repository.EntityRepository;
import java.net.URI;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import static edu.java.scrapper.repository.jdbc.SqlQueries.ADD_LINK;
import static edu.java.scrapper.repository.jdbc.SqlQueries.CONNECT_LINK_TO_CHAT;
import static edu.java.scrapper.repository.jdbc.SqlQueries.DELETE_LINK;
import static edu.java.scrapper.repository.jdbc.SqlQueries.FIND_ALL_BY_DELAY;
import static edu.java.scrapper.repository.jdbc.SqlQueries.FIND_CONNECTED_LINKS;
import static edu.java.scrapper.repository.jdbc.SqlQueries.FIND_LINK;
import static edu.java.scrapper.repository.jdbc.SqlQueries.FIND_LINK_BY_ID;
import static edu.java.scrapper.repository.jdbc.SqlQueries.REMOVE_LINK_FROM_CHAT;
import static edu.java.scrapper.repository.jdbc.SqlQueries.UPDATE_LINK;

@RequiredArgsConstructor
public class JdbcLinkRepository implements EntityRepository<Link, Long> {
    private final JdbcClient jdbcClient;
    private final BeanPropertyRowMapper<Link> mapper = new BeanPropertyRowMapper<>(Link.class);

    @Override
    public Link save(Link obj) {
        return jdbcClient.sql(ADD_LINK)
            .params(
                obj.getUri(),
                obj.getHost(),
                obj.getProtocol(),
                obj.getLastUpdatedAt()
            )
            .query(mapper).single();
    }

    @Override
    public Optional<Link> findById(Long identifier) {
        try {
            return Optional.of(jdbcClient.sql(FIND_LINK_BY_ID)
                .params(identifier)
                .query(mapper)
                .single());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Link delete(Link object) {
        return jdbcClient.sql(DELETE_LINK)
            .params(object.getId())
            .query(mapper).single();
    }

    public Collection<Link> findByChatId(Long id) {
        return jdbcClient.sql(FIND_CONNECTED_LINKS)
            .params(id)
            .query(mapper).list();
    }

    public Optional<Link> findByUrl(URI url) {
        try {
            return Optional.of(jdbcClient.sql(FIND_LINK)
                .params(url.toString())
                .query(mapper)
                .single());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public void connectLink(Long chat, Long link) {
        jdbcClient.sql(CONNECT_LINK_TO_CHAT)
            .params(
                chat,
                link
            )
            .update();
    }

    public void removeLink(Long chat, Long link) {
        jdbcClient.sql(REMOVE_LINK_FROM_CHAT)
            .params(
                chat,
                link
            )
            .update();
    }

    public void update(Link link) {
        jdbcClient.sql(UPDATE_LINK)
            .params(
                link.getLastUpdatedAt(),
                link.getId()
            )
            .update();
    }

    public Collection<Link> findAllWithInterval(Duration delay) {
        return jdbcClient.sql(FIND_ALL_BY_DELAY)
            .params(Timestamp.from(Instant.now().minusSeconds(delay.toSeconds())))
            .query(mapper).list();
    }
}
