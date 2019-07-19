package com.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.beans.Student;

public class StudentMapper implements RowMapper<Student> {
	//用来封装成实体对象
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setID(rs.getInt("id"));
		student.setNAME(rs.getString("name"));
		student.setAGE(rs.getInt("age"));
		return student;
	}

}
