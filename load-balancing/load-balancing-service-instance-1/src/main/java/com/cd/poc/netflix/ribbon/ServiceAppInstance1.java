package com.cd.poc.netflix.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ServiceAppInstance1 {

	public static void main(String[] args) {

		SpringApplication.run(ServiceAppInstance1.class, args);
	}

	

	@RequestMapping("/locaus")
	public String serverLocation() {
		System.out.println("Served By ServiceInstance 1");

		return "Australia";
	}

}
