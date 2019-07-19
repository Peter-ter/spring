package com.spring;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class CustomEventPublisher implements ApplicationEventPublisherAware {
	
	private ApplicationEventPublisher publish;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publish) {
		this.publish = publish;
	}
	//将事件发布传递给事件类
	//将事件类通过事件发布类的publishEvent方法发布
	public void publish() {
		CustomEvent ce = new CustomEvent(this);
		publish.publishEvent(ce);
	}


}
