package com.webonise.dao.impl;

import java.util.List;

import com.webonise.dao.StudentDAO;
import com.webonise.model.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Logger logger = LogManager.anonymousLogger();

	public void insertStudent(Student student) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(student);
		} catch(SQLException e) {
			logger.fatal("Unable to execute insert query.", e);
		} catch(Exception e) {
			logger.fatal("Exception occured at insertStudent() in StudentDaoImpl.class.", e);
		}
	}

	public List<Student> getAllStudents() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Student").list();
		} catch(SQLException e) {
			logger.fatal("Unable to execute select * query.", e);
		} catch(Exception e) {
			logger.fatal("Exception occured at getAllStudents() in StudentDaoImpl.class.", e);
		}
		return null;
	}

	public void deleteStudent(Integer studentId) {
		try {
			Student student = (Student) sessionFactory.getCurrentSession().load(Student.class, studentId);
			this.sessionFactory.getCurrentSession().delete(student);
		} catch(SQLException e) {
			logger.fatal("Unable to execute delete query.", e);
		} catch(Exception e) {
			logger.fatal("Exception occured at deleteStudent() in StudentDaoImpl.class.", e);
		}
	}

	public Student getStudent(int studentId) {
		try {
			return (Student) sessionFactory.getCurrentSession().get(Student.class, studentId);
		} catch(SQLException e) {
			logger.fatal("Unable to execute select query.", e);
		} catch(Exception e) {
			logger.fatal("Exception occured at getStudent() in StudentDaoImpl.class.", e);
		}
	}

	public Student updateStudent(Student student) {
		try {
			sessionFactory.getCurrentSession().update(student);
		} catch(SQLException e) {
			logger.fatal("Unable to execute update query.", e);
		} catch(Exception e) {
			logger.fatal("Exception occured at updateStudent() in StudentDaoImpl.class.", e);
		}
		return student;
	}
}
