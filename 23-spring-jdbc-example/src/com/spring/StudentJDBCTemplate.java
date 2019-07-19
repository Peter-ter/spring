package com.spring;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.beans.Student;
import com.spring.dao.StudentDao;
import com.spring.mapper.StudentMapper;

public class StudentJDBCTemplate implements StudentDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String name, Integer age) {
		String SQL = "insert into student(name,age) values(?,?)";
		jdbcTemplate.update(SQL, name, age);
		System.out.println("Created Record Name = " + name + " Age = " + age);
	}

	@Override
	public void delect(Integer id) {
		String SQL = "delete from Student where id = ?";
		jdbcTemplate.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
	}

	@Override
	public void update(Integer id, Integer age) {
		String SQL = "update Student set age = ? where id = ?";
		jdbcTemplate.update(SQL, age, id);
		System.out.println("Updated Record with ID = " + id);
	}

	@Override
	public Student select(Integer id) {
		String SQL = "select * from Student where id = ?";
		Student student = jdbcTemplate.queryForObject(SQL, 
							new Object[] { id }, new StudentMapper());
		return student;
	}

	@Override
	public List<Student> listStudent() {
		String SQL = "select * from Student";
	      List <Student> students = jdbcTemplate.query(SQL, 
	                                new StudentMapper());
	      return students;
	}

}
