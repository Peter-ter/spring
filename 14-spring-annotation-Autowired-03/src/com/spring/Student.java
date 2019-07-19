package com.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	@Autowired(required = false)
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	@Autowired
	public void setAge(int age) {
		this.age = age;
	}
}
