package com.cd.poc.microservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException {

	public PersonNotFoundException() {

	}

	public PersonNotFoundException(String msg) {

		super("No such person : " + msg);

	}

}
