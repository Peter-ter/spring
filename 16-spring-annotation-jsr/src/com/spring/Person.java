package com.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class Person {
	
	@Resource(name = "student1")
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
	@PostConstruct
	public void init() {
		System.out.println("执行init的方法");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("执行destroy的方法");
	}

}
