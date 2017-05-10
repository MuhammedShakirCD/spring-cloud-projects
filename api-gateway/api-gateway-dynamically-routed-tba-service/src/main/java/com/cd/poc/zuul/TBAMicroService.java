package com.cd.poc.zuul;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TBAMicroService {

	public static void main(String[] args) {

		SpringApplication.run(TBAMicroService.class, args);
	}

	
	@RequestMapping(value = "/enrollment/plans")
	public List<String> getPlans() {
		System.out.println(" /enrollment/plans - Making SOAP call to hasbro and getting the data");
		List<String> plans = new ArrayList<>();
		plans.add("Plan 1 (10005)");
		plans.add("Plan 2 (10002)");
		return plans;
	}
}
