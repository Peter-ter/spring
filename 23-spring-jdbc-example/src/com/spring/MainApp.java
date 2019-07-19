package com.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.beans.Student;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
		System.out.println("------Records Creation--------");
		studentJDBCTemplate.create("Zara", 11);
		studentJDBCTemplate.create("Nuha", 2);
		studentJDBCTemplate.create("Ayan", 15);
		System.out.println("------Listing Multiple Records--------");
		List<Student> students = studentJDBCTemplate.listStudent();
		for (Student record : students) {
			System.out.print("ID : " + record.getID());
			System.out.print(", Name : " + record.getNAME());
			System.out.println(", Age : " + record.getAGE());
		}
		System.out.println("----Updating Record with ID = 2 -----");
		studentJDBCTemplate.update(2, 20);
		System.out.println("----Listing Record with ID = 2 -----");
		Student student = studentJDBCTemplate.select(2);
		System.out.print("ID : " + student.getID());
		System.out.print(", Name : " + student.getNAME());
		System.out.println(", Age : " + student.getAGE());
	}

}
