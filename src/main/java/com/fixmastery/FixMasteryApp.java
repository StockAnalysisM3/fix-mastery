package com.fixmastery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FixMasteryApp {

	public static void main(String[] args) {
		SpringApplication.run(FixMasteryApp.class, args);

		/**
		 * To run, please maven install, then spring-boot run
		 * After that, please open localhost:8080/
		 *
		 * We will be utilizing H2 database
		 * The CapitalRepository will be used in place of the Hashmap<String, Capital>
		 *     Because of the @Autowire annotation, Spring will take take of injecting CapitalRepository into CapitalService
		 *
		 * The CommandLineRunner will run the loadFromText service upon initialization
		 */
	}

}
