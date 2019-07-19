package com.spring;



public class Logging {
	
	public void beforeGetName() {
		System.out.println("在getName之前执行该方法");
	}
	public void afterGetName() {
		System.out.println("在getName后执行该方法");
	}
	public void returnGetName(Object result) {
		System.out.println("return value : " + result);
	}
	/*public void exceptionGetName(Exception ex) {
		System.out.println("throwing : " + ex);
	}
	public void aroundGetName() {
		System.out.println("在getName方法执行前后执行");
	}*/
	
}
