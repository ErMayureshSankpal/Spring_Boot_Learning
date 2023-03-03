package com.example.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompanyApplication {

	private static final Logger log = LogManager.getLogger(CompanyApplication.class);

	public static void main(String[] args) {
		log.info("Application is started.");
		SpringApplication.run(CompanyApplication.class, args);
	}

}
