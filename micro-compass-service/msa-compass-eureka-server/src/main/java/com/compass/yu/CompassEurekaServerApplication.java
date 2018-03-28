package com.compass.yu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CompassEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompassEurekaServerApplication.class, args);
	}
}
