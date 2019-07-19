package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		CustomEventPublisher publisher = (CustomEventPublisher)context.getBean("publisher");
		publisher.publish();
		publisher.publish();
	}

}
