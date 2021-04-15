package ua.deti.tqs.carinfosystem.car;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void whenFindAronaById_thenReturnAronaCar() {
        Car arona = new Car("seat", "arona");
        entityManager.persistAndFlush(arona);

        Optional<Car> found = carRepository.findByCarID(arona.getCarID());
        assertThat( found.get() ).isEqualTo(arona);
    }

    @Test
    public void whenInvalidCarID_thenReturnNull() {
        Optional<Car> fromDb = carRepository.findByCarID((long) -222);
        assertThat(fromDb.isEmpty());
    }

    @Test
    public void givenSetOfCars_whenFindAll_thenReturnAllCars() {
        Car arona = new Car("seat", "arona");
        Car punto = new Car("fiat", "punto");
        Car c3 = new Car("citroen", "c3");

        entityManager.persist(arona);
        entityManager.persist(punto);
        entityManager.persist(c3);
        entityManager.flush();

        List<Car> allCars = carRepository.findAll();

        assertThat(allCars).hasSize(3)
                .extracting(Car::getMaker)
                .containsOnly(arona.getMaker(), punto.getMaker(), c3.getMaker());
    }

}