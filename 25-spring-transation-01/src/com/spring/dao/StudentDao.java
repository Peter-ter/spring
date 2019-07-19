package com.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.transaction.PlatformTransactionManager;

import com.spring.beans.Student;
import com.spring.beans.StudentMarks;

public interface StudentDao {
	//添加数据库连接串
	public void setDataSource(DataSource dataSource);
	public void setTransactionManager(PlatformTransactionManager transactionManager);
	public void create(String name , Integer age,Integer marks, Integer year);
	public List<StudentMarks> listStudent();
}
