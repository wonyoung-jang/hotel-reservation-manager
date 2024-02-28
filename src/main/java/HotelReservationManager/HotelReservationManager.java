package HotelReservationManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class HotelReservationManager {
	public static void main(String[] args) {
		SpringApplication.run(HotelReservationManager.class, args);
	}
}
