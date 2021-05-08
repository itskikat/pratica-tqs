package ua.deti.tqs.carinfosystem.car;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;


import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;


@WebMvcTest(CarController.class)
class CarControllerTestWebMockMvc {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarManagerService cmservice;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mvc);
    }

    @Test
    public void whenPostCar_thenCreateCar() throws Exception {
        Car seat = new Car("seat", "arona");
        seat.setCarID(001L);

        when(cmservice.save(any())).thenReturn(seat);

        RestAssuredMockMvc.given()
                                    .accept(ContentType.JSON)
                                    .contentType(ContentType.JSON)
                                    .body(JsonUtil.toJson(seat))

                            .when()
                                    .post("/api/cars")
                            .then()
                                    .assertThat()
                                    .statusCode(201)
                                    .and()
                                        .body("maker", equalTo(seat.getMaker()))
                                    .and()
                                        .body("model", equalTo(seat.getModel()));

    }

    @Test
    public void whenGetCarByID_thenReturnOneCar() throws Exception {
        Car thecar = new Car();
        thecar.setMaker("seat");
        thecar.setModel("arona");
        thecar.setCarID((long)1);

        when(cmservice.getCarDetails(1l)).thenReturn(Optional.of(thecar));

        RestAssuredMockMvc.given()
                                    .accept(ContentType.JSON)
                                    .contentType(ContentType.JSON)
                            .when()
                                    .get("/api/cars/{id}", thecar.getCarID())
                            .then()
                                    .assertThat()
                                    .statusCode(200)
                                    .and()
                                        .body("model", equalTo(thecar.getModel()));

    }

}