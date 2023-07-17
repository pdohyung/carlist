package carlist.carlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import carlist.carlist.domain.Car;
import carlist.carlist.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class CarListApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarListApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000));
		carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000));
		carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000));

		for(Car car : carRepository.findAll()){
			logger.info(car.getBrand() + " " + car.getModel());
		}
	}
}
