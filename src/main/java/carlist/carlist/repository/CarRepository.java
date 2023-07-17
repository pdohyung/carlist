package carlist.carlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import carlist.carlist.domain.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
