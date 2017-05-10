package com.cd.poc.microservices.services.person;

import java.io.Serializable;

public class Person implements Serializable {

	
	private int id = 101;
	private String name = "Muhammed Shakir";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
