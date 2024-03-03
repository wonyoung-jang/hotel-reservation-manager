package com.wjang.hotel_reservation_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
@EntityScan(basePackages = "com.wjang.hotel_reservation_manager.entity")
public class HotelReservationManager {
	public static void main(String[] args) {
		SpringApplication.run(HotelReservationManager.class, args);
	}
}
