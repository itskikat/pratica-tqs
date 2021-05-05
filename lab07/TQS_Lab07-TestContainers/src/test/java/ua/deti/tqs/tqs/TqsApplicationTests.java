package ua.deti.tqs.tqs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
class TqsApplicationTests {

    @Autowired
    AthleteRepository athleteRepository;

    @Container
    public static PostgreSQLContainer container = new PostgreSQLContainer("postgres:12")
            .withUsername("itskikat")
            .withPassword("demo")
            .withDatabaseName("athletes_test");

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username", container::getUsername);
    }


    @Test
    void whenInsertOneAthlete_thenShouldSucceed() {
        Athlete athlete = new Athlete();
        athlete.setName("Mathew Fraser");
        athleteRepository.save(athlete);
    }

}
