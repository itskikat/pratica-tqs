package ua.deti.tqs.carinfosystem.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CarManagerServiceTest {

    @Mock(lenient = true)
    private CarRepository carRepository;

    @InjectMocks
    private CarManagerService carService;

    @BeforeEach
    public void setUp() {
        Car arona = new Car("seat", "arona");
        arona.setCarID((long)1);

        Car punto = new Car("fiat", "punto");
        Car c3 = new Car("citroen", "c3");

        List<Car> allCars = Arrays.asList(arona, punto, c3);

        when(carRepository.findByCarID(arona.getCarID())).thenReturn(Optional.of(arona));
        when(carRepository.findAll()).thenReturn(allCars);
        when(carRepository.findByCarID(-02L)).thenReturn(null);
    }

    @Test
    public void whenValidID_thenCarShouldBeFound() {
        Long id = (long) 1;
        Optional<Car> found = carService.getCarDetails(id);
        if (!found.isEmpty()){
            assertThat(found.get().getCarID()).isEqualTo(id);
        }


    }

    @Test
    public void whenInvalidID_thenCarShouldNotBeFound() {
        Optional<Car> fromDb = carService.getCarDetails(-02L);
        assertThat(fromDb.isEmpty());

        verify(carRepository, times(1)).findByCarID(-02L);
    }

    @Test
    public void given3Cars_whenGetAll_thenReturn3Records() {
        Car arona = new Car("seat", "arona");
        Car punto = new Car("fiat", "punto");
        Car c3 = new Car("citroen", "c3");

        List<Car> allCars = carService.getAllCars();

        assertThat(allCars).hasSize(3).extracting(Car::getMaker).contains(arona.getMaker(), punto.getMaker(), c3.getMaker());

        verify(carRepository, times(1)).findAll();
    }

    @Test
    public void saveTest() {
        Car arona = new Car("seat", "arona");

        when(carRepository.save(arona)).thenReturn(arona);

        Car test = carService.save(arona);

        assertThat(test.getMaker()).isEqualTo(arona.getMaker());
        assertThat(test.getModel()).isEqualTo(arona.getModel());

        verify(carRepository, times(1)).save(arona);
    }
}