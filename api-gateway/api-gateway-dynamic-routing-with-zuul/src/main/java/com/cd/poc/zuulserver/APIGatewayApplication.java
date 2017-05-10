package com.cd.poc.zuulserver;

import com.cd.poc.zuulserver.filters.pre.TBACBARoutingFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 
 * <h2>Setup</h2>
 * <ol>
 *   <li>Create 3 schemas in MySql named as tenant1, tenant2 & tenant3</li>
 *   <li>Import the 3 projects provided</li>
 *   <li>Run all the projects as SpringBoot apps (actually just like java apps)</li>
 * </ol>
 * <hr>
 * 
 * Usage : Fire curl command as follows to test the routing happening to CBA
 * (any value of client id other than 2002 will hit the CBA service) service which
 * is multi-tenancy based <br>
 * <br>

 * <ol>
 * <li>For Tenant 1 : curl --header "X-ClientId: 2" --header "X-TenantName:
 * tenant1" http://localhost:8080/hm/enrollment/plans</li>
 * 
 * <li>For Tenant 1 : curl --header "X-ClientId: 2" --header "X-TenantName:
 * tenant2" http://localhost:8080/hm/enrollment/plans</li>
 * 
 * 
 * <li>For Tenant 1 : curl --header "X-ClientId: 2" --header "X-TenantName:
 * tenant3" http://localhost:8080/hm/enrollment/plans</li>
 * 
 * </ol>
 * 
 * 
 * <p>
 *  To hit TBA service
 *  <hr>
 *  curl --header "X-ClientId: 2" --header "X-TenantName:
 * tenant3" http://localhost:8080/hm/enrollment/plans
 * 
 *   
 * </p>
 * 
 * 
 * @author MuhammedShakir
 *
 */
@SpringBootApplication
@EnableZuulProxy
public class APIGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(APIGatewayApplication.class, args);
	}

	@Bean
	public TBACBARoutingFilter preFilter() {

		return new TBACBARoutingFilter();

	}
}
