package com.cd.poc.microservices.services.enrollment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class EnrollmentController {

	protected String serviceUrl = "http://PERSON-SERVICE";

	@Autowired
	protected RestTemplate restTemplate;

	@RequestMapping("/enrollment")
	public String getPerson() {

		
		System.out.println("The final URL :" + serviceUrl + "/persons/{number}");
		
		Person p = restTemplate.getForObject(serviceUrl + "/persons/{number}", Person.class, 2010);

		System.out.println("Person : " + p.getId() + " -- " + p.getName());

		return "index";

	}

}
