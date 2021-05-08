package ua.deti.tqs.carinfosystem.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarManagerService {

    @Autowired
    private CarRepository carRepository;


    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Optional<Car> getCarDetails(Long carID) {
        return carRepository.findByCarID(carID);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
