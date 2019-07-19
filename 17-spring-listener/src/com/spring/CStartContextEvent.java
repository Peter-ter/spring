package com.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class CStartContextEvent implements ApplicationListener<ContextStartedEvent> {

	@Override
	public void onApplicationEvent(ContextStartedEvent event) {
		
		System.out.println("执行Application.start()方法");
	}

}
