package com.example.springtest;
import org.junit.jupiter.api.Test; // JUnit 5 Test annotation
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.jdbc.Sql;
import static org.junit.jupiter.api.Assertions.*; // Assertions for JUnit 5
@SpringJUnitConfig(classes = AppConfig.class)
class UserRepositoryTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    @Sql(scripts = "classpath:cleanup.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD) // Ensure SQL script path is correct
    void testDatabase() {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users", Integer.class);
        assertNotNull(count, "Count should not be null");
        assertTrue(count > 0, "Count should be greater than zero");
    }
}
