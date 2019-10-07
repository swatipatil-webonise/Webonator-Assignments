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

	public void insertStudent(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
	}

	public List<Student> getAllStudents() {
		return sessionFactory.getCurrentSession().createQuery("from Student").list();
	}

	public void deleteStudent(Integer studentId) {
		Student student = (Student) sessionFactory.getCurrentSession().load(Student.class, studentId);
		if (null != student) {
			this.sessionFactory.getCurrentSession().delete(student);
		}
	}

	public Student getStudent(int studentId) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class, studentId);
	}

	public Student updateStudent(Student student) {
		sessionFactory.getCurrentSession().update(student);
		return student;
	}
}
