package com.cd.poc.zuul;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping(value = "/simple")
	public String simpleRequest() throws IOException {

		// response.getWriter().print("<html><body><h1>Welcome</h1></body></html>");

		System.out.println("In simpleRequest");
		return "index";

	}

}
