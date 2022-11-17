package com.example.parkingspot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingspotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingspotApplication.class, args);
	}

}
// TODO
// @Configuration classes
// Refactor querys in carRepo class
// Refactor ResponseEntity to fluid API "return ResponseEntity.ok().body()..."
// Include URI location in Post endpoints on .created()
// Replace transient id to work with id inside Entity/obj when passed