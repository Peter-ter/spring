package com.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class CStopContextEvent implements ApplicationListener<ContextStoppedEvent> {

	@Override
	public void onApplicationEvent(ContextStoppedEvent arg0) {
		System.out.println("这里执行ApplicationContext.stop()方法");
	}

}
