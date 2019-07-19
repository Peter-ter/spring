package com.spring;

import org.springframework.beans.factory.annotation.Required;

public class Student {
	private String name;

	public String getName() {
		return name;
	}
	@Required
	public void setName(String name) {
		this.name = name;
	}

	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
