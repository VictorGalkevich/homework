package edu.java.scrapper.repository;

import edu.java.scrapper.IntegrationTest;
import edu.java.scrapper.ScrapperIT;
import edu.java.scrapper.entity.Chat;
import edu.java.scrapper.repository.jdbc.JdbcChatRepository;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ScrapperIT
public class JdbcChatRepositoryTest extends IntegrationTest {
    @Autowired
    private JdbcChatRepository userRepository;
    private static final Chat TEST_CHAT;
    private static final Long TEST_ID = 123L;

    static {
        TEST_CHAT = Chat.builder()
            .id(123L)
            .links(new ArrayList<>())
            .createdAt(OffsetDateTime.now())
            .build();
    }

    @DynamicPropertySource
    public static void setJdbcAccessType(DynamicPropertyRegistry registry) {
        registry.add("app.database-access-type", () -> "jdbc");
    }

    @Test
    void testAddPositive() {
        Chat save = userRepository.save(TEST_CHAT);
        assertEquals(TEST_CHAT.getId(), save.getId());
        assertEquals(TEST_CHAT.getLinks(), save.getLinks());
    }

    @Test
    void testFindByIdExistsPositive() {
        userRepository.save(TEST_CHAT);
        Optional<Chat> found = userRepository.findById(TEST_ID);
        assertTrue(found.isPresent());
    }

    @Test
    void testFindByIdDoesNotExist() {
        assertTrue(userRepository.findById(TEST_ID).isEmpty());
    }

}
