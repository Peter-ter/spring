package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		HelloWorld helloWorld = context.getBean(HelloWorld.class);
		helloWorld.setMessage("Hello World!");
		helloWorld.getMessage();
	}
	

}
