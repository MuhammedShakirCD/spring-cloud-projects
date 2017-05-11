package com.cd.poc.netflix.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ServiceAppInstance2 {

	public static void main(String[] args) {

		SpringApplication.run(ServiceAppInstance2.class, args);
	}

	@RequestMapping("/locaus")
	public String serverLocation() {

		System.out.println("Served By ServiceInstance 2");
		return "Australia";
	}

}
