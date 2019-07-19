package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		  ApplicationContext context = 
		             new AnnotationConfigApplicationContext(TextEditorConfig.class);
		      TextEditor te = context.getBean(TextEditor.class);
		      te.spellCheck();
	}

}
