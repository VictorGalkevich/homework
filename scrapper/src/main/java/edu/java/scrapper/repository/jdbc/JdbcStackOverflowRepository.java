package edu.java.scrapper.repository.jdbc;

import edu.java.scrapper.entity.GitHubLink;
import edu.java.scrapper.entity.Link;
import edu.java.scrapper.entity.StackOverflowLink;
import edu.java.scrapper.repository.LinkUpdateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import static edu.java.scrapper.repository.jdbc.SqlQueries.*;

@Repository
@RequiredArgsConstructor
public class JdbcStackOverflowRepository implements LinkUpdateRepository<StackOverflowLink> {
    private final JdbcClient jdbcClient;
    private final BeanPropertyRowMapper<StackOverflowLink> mapper = new BeanPropertyRowMapper<>(StackOverflowLink.class);
    @Override
    public Optional<StackOverflowLink> findLink(Link link) {
        try {
            return Optional.of(jdbcClient.sql(FIND_SOF_LINK)
                .params(link.getId())
                .query(mapper)
                .single());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public StackOverflowLink save(StackOverflowLink link) {
        return jdbcClient.sql(ADD_SOF_LINK)
            .params(link.getId(),
                link.getAnswerCount(),
                link.getScore())
            .query(mapper)
            .single();
    }

    @Override
    public void update(StackOverflowLink link) {
        jdbcClient.sql(UPDATE_SOF_LINK)
            .params(link.getAnswerCount(),
                link.getScore(),
                link.getId())
            .update();
    }
}
