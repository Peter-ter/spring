package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {
	@Autowired
	@Qualifier("student1")
	private Student student;

	public Person() {
		System.out.println("Inside Person constructor.");
	}

	public void printAge() {
		System.out.println("Age : " + student.getAge());
	}

	public void printName() {
		System.out.println("Name : " + student.getName());
	}

}
