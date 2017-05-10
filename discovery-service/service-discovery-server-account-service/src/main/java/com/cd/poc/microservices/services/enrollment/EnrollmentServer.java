package com.cd.poc.microservices.services.enrollment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false) // Disable component scanner
public class EnrollmentServer {

	public static void main(String[] args) {

		System.setProperty("spring.config.name", "enrollment-server");
		SpringApplication.run(EnrollmentServer.class, args);

	}

	@Bean
	public EnrollmentController enrollmentController() {
		return new EnrollmentController();
	}

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
