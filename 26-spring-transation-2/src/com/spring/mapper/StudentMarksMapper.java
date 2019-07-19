package com.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.beans.Student;
import com.spring.beans.StudentMarks;

public class StudentMarksMapper implements RowMapper<StudentMarks> {
	//用来封装成实体对象
	@Override
	public StudentMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentMarks stuMarks = new StudentMarks();
		stuMarks.setId(rs.getInt("id"));
		stuMarks.setName(rs.getString("name"));
		stuMarks.setAge(rs.getInt("age"));
		stuMarks.setMarks(rs.getInt("marks"));
		stuMarks.setYear(rs.getInt("year"));
		return stuMarks;
	}

}
