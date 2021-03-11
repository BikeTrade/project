package com.biketrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BikeTradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikeTradeApplication.class, args);
	}

}
