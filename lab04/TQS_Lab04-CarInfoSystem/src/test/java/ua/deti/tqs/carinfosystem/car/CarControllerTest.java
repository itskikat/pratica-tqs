package ua.deti.tqs.carinfosystem.car;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.aMapWithSize;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest
class CarControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarManagerService cmservice;

    @Test
    public void whenPostCar_thenCreateCar() throws Exception {
        Car seat = new Car("seat", "arona");
        seat.setCarID(001L);

        when(cmservice.save(any())).thenReturn(seat);

        mvc.perform(post("/api/cars").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(seat)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.maker", is("seat")));

        verify(cmservice, times(1)).save(any());
    }

    @Test
    public void whenGetCarByID_thenReturnOneCar() throws Exception {
        Car thecar = new Car();
        thecar.setMaker("seat");
        thecar.setModel("arona");
        thecar.setCarID((long)1);

        when(cmservice.getCarDetails(thecar.getCarID())).thenReturn(Optional.of(thecar));

        mvc.perform(get("/api/cars/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", aMapWithSize(3)))
                .andExpect(jsonPath("$.maker", is(thecar.getMaker())))
                .andExpect(jsonPath("$.model", is(thecar.getModel())));

        verify(cmservice, times(1)).getCarDetails(001L);

    }

}