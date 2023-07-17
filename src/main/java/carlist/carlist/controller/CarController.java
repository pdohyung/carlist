package carlist.carlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carlist.carlist.domain.Car;
import carlist.carlist.repository.CarRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CarController {

	private final CarRepository carRepository;
	@GetMapping("/cars")
	public List<Car> getCars(){
		return carRepository.findAll();
	}
}
