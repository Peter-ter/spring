package com.spring;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.spring.beans.Student;
import com.spring.beans.StudentMarks;
import com.spring.dao.StudentDao;
import com.spring.mapper.StudentMarksMapper;

public class StudentJDBCTemplate implements StudentDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager transactionManager;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public void create(String name, Integer age, Integer marks, Integer year) {
		// 定义事务
		TransactionDefinition def = new DefaultTransactionDefinition();
		// 开始事务
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			// 当插入student表成功时需要插入marks表成功，不然就算失败
			String SQL1 = "insert into Student(name,age) values(?,?)";
			jdbcTemplate.update(SQL1, name, age);

			String SQL2 = "select max(id) from student";
			Integer sid = jdbcTemplate.queryForObject(SQL2, Integer.class);

			String SQL3 = "insert into marks(sid,marks,year) values(?,?,?)";
			jdbcTemplate.update(SQL3, sid, marks, year);
			System.out.println("Created Name = " + name + ", Age = " + age);
			// 事务成功
			transactionManager.commit(status);
		} catch (Exception e) {
			// 事务失败
			System.out.println("Error in creating record, rolling back");
			transactionManager.rollback(status);
			throw e;
		}

	}

	@Override
	public List<StudentMarks> listStudent() {
		String SQL = "select * from Student, Marks where Student.id=Marks.sid";
		List<StudentMarks> studentMarks = jdbcTemplate.query(SQL, new StudentMarksMapper());
		return studentMarks;
	}

}
