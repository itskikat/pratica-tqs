package ua.deti.tqs.carinfosystem.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, Long> {

    public Optional<Car> findByCarID(Long carID);
    public List<Car> findAll();

}
