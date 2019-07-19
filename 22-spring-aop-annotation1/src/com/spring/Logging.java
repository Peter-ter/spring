package com.spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logging {
	
	//将方法名作为切入点的ID
	@Pointcut("execution(* com.spring.Student.getName(..))")
	private void businessService() {}
	
	//与切入点绑定在一起
	@Before("businessService()")
	public void beforeGetName() {
		System.out.println("在getName之前执行该方法");
	}
	
	@After("businessService()")
	public void afterGetName() {
		System.out.println("在getName后执行该方法");
	}
	@AfterReturning(pointcut = "businessService()",returning = "result")
	public void returnGetName(Object result) {
		System.out.println("return value : " + result);
	}
	
	/*@AfterThrowing(pointcut = "businessService()",throwing = "ex")
	public void exceptionGetName(Exception ex) {
		System.out.println("throwing : " + ex);
	}
	@Around("businessService()")
	public void aroundGetName() {
		System.out.println("在getName方法执行前后执行");
	}*/
	
}
