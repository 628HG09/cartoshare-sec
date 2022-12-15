package nl.novi.techiteasy1121.repositories;

import nl.novi.techiteasy1121.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
