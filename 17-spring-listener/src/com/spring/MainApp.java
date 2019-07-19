package com.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		context.start();
		Person person = (Person) context.getBean("person");
		person.printName();
		person.printAge();
		context.stop();
	}

}
