package ua.deti.tqs.carinfosystem.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarManagerService carManagerService;

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car newCar){
        HttpStatus status = HttpStatus.CREATED;
        Car saved = carManagerService.save(newCar);
        return new ResponseEntity<>(saved, status);
    }

    @GetMapping ("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable(value = "id") long carId) {
        Optional<Car> car = carManagerService.getCarDetails(carId);
        if (!car.isEmpty()){
            return ResponseEntity.ok(car.get());
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping(value = "/cars", produces = "application/json")
    public List<Car> getAllCars() {
        return carManagerService.getAllCars();
    }
}
