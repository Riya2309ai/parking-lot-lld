package com.riya.parkinglot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingLotLldApplication {

	public static void main(String[] args) {

		ParkingLotSimulator.run();

		SpringApplication.run(ParkingLotLldApplication.class, args);
	}

}
