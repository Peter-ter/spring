package com.spring;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.spring.beans.Student;
import com.spring.dao.StudentDao;
import com.spring.mapper.StudentMapper;

public class StudentJDBCTemplate implements StudentDao {

	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcCall =  new SimpleJdbcCall(dataSource).
                withProcedureName("getRecord");
	}

	@Override
	public void create(String name, Integer age) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
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
		SqlParameterSource in = 
				new MapSqlParameterSource().addValue("in_id", id);
		Map<String, Object> out = jdbcCall.execute(in);
		Student student = new Student();
		student.setID(id);
		student.setNAME((String) out.get("out_name"));
		student.setAGE((Integer) out.get("out_age"));
		return student;
	}

	@Override
	public List<Student> listStudent() {
		String SQL = "select * from Student";
		List<Student> students = jdbcTemplate.query(SQL, new StudentMapper());
		return students;
	}

}
