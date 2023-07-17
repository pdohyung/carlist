package carlist.carlist;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import carlist.carlist.domain.Car;
import carlist.carlist.domain.Owner;
import carlist.carlist.repository.CarRepository;
import carlist.carlist.repository.OwnerRepository;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class CarListApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private OwnerRepository ownerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarListApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = ownerRepository.save(new Owner("John", "Johnson"));
		Owner owner2 = ownerRepository.save(new Owner("Mary", "Robinson"));

		ownerRepository.saveAll(Arrays.asList(owner1, owner2));

		Car car1 = carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, owner1));
		Car car2 = carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000, owner2));
		Car car3 = carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000, owner2));

		carRepository.saveAll(Arrays.asList(car1, car2, car3));

		for(Car car : carRepository.findAll()){
			logger.info(car.getBrand() + " " + car.getModel());
		}
	}
}
