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
// Refactor relations OtM, MtO
// Look over CascadeTypes
// @Configuration classes
// Refactor querys in carRepo class