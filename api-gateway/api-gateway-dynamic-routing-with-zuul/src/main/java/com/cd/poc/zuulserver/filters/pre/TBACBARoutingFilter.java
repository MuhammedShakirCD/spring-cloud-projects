package com.cd.poc.zuulserver.filters.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import java.net.URL;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TBACBARoutingFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(TBACBARoutingFilter.class);

	@Override
	public boolean shouldFilter() {

		return true;
	}

	@Override
	public Object run() {

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		Enumeration<String> allHeaders = request.getHeaderNames();

		while (allHeaders.hasMoreElements()) {

			String headerName = allHeaders.nextElement();

			String headerValue = request.getHeader(headerName);
			System.out.println(headerName + " = " + headerValue);

		}
		
		System.out.println(" *********** ");

		// here you get the clientId from header
		// Call a common service that will help you to decide whether to call
		// TBA or CBA
		// based on this you will route to appropriate port

		String clientId = request.getHeader("x-clientid");
		System.out.println("Got client is : " + clientId);

		try {
			if (clientId.equals("2002")) { // considering that clientId 2002 is from
										// CBA
				// routing to tba
				System.out.println("routing to cba : port 9000");
//				ctx.addOriginResponseHeader("origina-header-reponse", "origin value");
//				ctx.addZuulRequestHeader("zuul request header", "request value");
//				ctx.addZuulResponseHeader("zuul response header", "response value");
				ctx.setRouteHost(new URL("http://localhost:9000"));
			} else {
				// routing to cba
				System.out.println("routing to tba: port 9001");
				ctx.setRouteHost(new URL("http://fish.myschoolstack.com:9001"));
			}
		} catch (Exception ex) {
		}
		
		log.info(request.getPathInfo());

		return null;
	}

	@Override
	public String filterType() {

		return "route";

	}

	@Override
	public int filterOrder() {

		return 1;
	}

}