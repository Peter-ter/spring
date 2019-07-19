package com.spring;


public class Student {
	private String name;

	public String getName() {
		System.out.println(this.name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int age;

	public int getAge() {
		System.out.println(this.age);
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
