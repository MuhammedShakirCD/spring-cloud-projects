package com.cd.poc.controllers;

import com.cd.poc.TenantContext;
import com.cd.poc.domain.Plan;
import com.cd.poc.domain.PlanRepository;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlanController {

	public PlanController() {

		System.out.println("*************************** PlanController Instantiated...");
	}

	@Autowired
	private PlanRepository planRepository;

	@RequestMapping(value = "/enrollment/plans")
	// public ResponseEntity<?> getPlans(HttpServletRequest request,
	// HttpServletResponse response) {
	public ResponseEntity<?> getPlans(@RequestHeader("X-TenantName") String tenantName, HttpServletRequest request,
			HttpServletResponse response) {

		// String tenantName = "tenant1";
		System.out.println("Client Id received by CBA Services i : " + tenantName);

		// Enumeration<String> allHeaders = request.getHeaderNames();
		//
		// System.out.println("Headers in CBA Service.....");
		// while (allHeaders.hasMoreElements()) {
		//
		// String headerName = allHeaders.nextElement();
		//
		// String headerValue = request.getHeader(headerName);
		// System.out.println(headerName + " = " + headerValue);
		//
		// }
		//
		// Enumeration<String> params = request.getParameterNames();
		// while (params.hasMoreElements()) {
		//
		// String param = params.nextElement();
		//
		// String paramValue = request.getParameter(param);
		// System.out.println(param + " = " + paramValue);
		//
		// }
		//
		// System.out.println(" *********** ");

		System.out.println(" /enrollment/plans - CBA Mocking service is executed... Returning hard coded data");

		TenantContext.setCurrentTenant(tenantName);

		Plan plan = planRepository.findOne(101);
		System.out.println("plan : " + plan.getName());

		List<Plan> plans = new ArrayList<>();
		plans.add(plan);

		return ResponseEntity.ok(plans);

	}

}
