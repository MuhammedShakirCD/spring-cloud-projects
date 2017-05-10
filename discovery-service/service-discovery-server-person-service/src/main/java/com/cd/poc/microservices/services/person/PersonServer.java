package com.cd.poc.microservices.services.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(PersonServiceConfiguration.class)
public class PersonServer {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "person-server");

		SpringApplication.run(PersonServer.class, args);

	}

}
