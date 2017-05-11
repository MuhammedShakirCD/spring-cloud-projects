package com.cd.poc.netflix.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@RibbonClient(name = "ping-a-server", configuration = RibbonConfiguration.class)
public class RibbonOrientedClientService {

	public static void main(String[] args) {

		SpringApplication.run(RibbonOrientedClientService.class, args);
	}

	@LoadBalanced
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/server-location")
	public String serverLocation() {

		String servLoc = this.restTemplate.getForObject("http://SPRING-CLOUD-RIBBON-SERVICE/locaus", String.class);

		System.out.println("In server-location");

		return servLoc;
	}

}
