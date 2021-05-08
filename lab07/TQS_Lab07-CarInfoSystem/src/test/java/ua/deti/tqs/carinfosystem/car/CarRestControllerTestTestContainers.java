package ua.deti.tqs.carinfosystem.car;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.IOException;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public class CarRestControllerTestTestContainers {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private CarRepository repository;

    @Container
    public static PostgreSQLContainer container = new PostgreSQLContainer("postgres:12")
            .withUsername("itskikat")
            .withPassword("demo")
            .withDatabaseName("cars_test");

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username", container::getUsername);
    }

    @AfterEach
    public void resetDb() {
        repository.deleteAll();
    }


    @Test
    public void whenValidInput_thenCreateCar() throws IOException {
        Car seat = new Car("seat", "arona");
        repository.saveAndFlush(seat);

        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(JsonUtil.toJson(seat))
        .when()
                .post("http://localhost:" + randomServerPort + "/api/cars")
        .then()
                .assertThat()
                .statusCode(201)
                .and()
                    .body("maker", equalTo(seat.getMaker()))
                .and()
                    .body("model", equalTo(seat.getModel()));
    }

    @Test
    public void givenCars_whenGetCars_thenStatus200() {
        createTestCar("seat", "arona");
        createTestCar("citroen", "c3");

        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
        .when()
                .get("http://localhost:" + randomServerPort + "/api/cars")
        .then()
                .assertThat()
                .statusCode(200)
                .and()
                    .body("maker[0]", is("seat"))
                .and()
                    .body("maker[1]", is("citroen"))
                .and()
                    .body("model[0]", is("arona"))
                .and()
                    .body("model[0]", is("c3"));
    }

    private void createTestCar(String maker, String model){
        Car c = new Car(maker, model);
        repository.saveAndFlush(c);
    }

}
