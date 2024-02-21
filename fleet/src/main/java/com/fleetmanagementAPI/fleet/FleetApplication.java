package com.fleetmanagementAPI.fleet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController; // Agregar importación para RestController

@SpringBootApplication
@RestController
public class FleetApplication {

	public static void main(String[] args) {
		SpringApplication.run(FleetApplication.class, args);
	}

}
