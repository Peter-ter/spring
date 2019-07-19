package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Student stu = (Student) context.getBean("student");
		System.out.println("student's name is " + stu.getName());
		System.out.println("student's age is " + stu.getAge());
	}

}
