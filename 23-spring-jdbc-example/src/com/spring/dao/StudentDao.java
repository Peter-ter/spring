package com.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import com.spring.beans.Student;

public interface StudentDao {
	//添加数据库连接串
	public void setDataSource(DataSource dataSource);
	public void create(String name , Integer age);
	public void delect(Integer id);
	public void update(Integer id, Integer age);
	public Student select(Integer id); 
	public List<Student> listStudent();
}
