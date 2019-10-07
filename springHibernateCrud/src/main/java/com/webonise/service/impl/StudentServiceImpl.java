package com.webonise.service.impl;

import java.util.List;

import com.webonise.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webonise.dao.StudentDAO;
import com.webonise.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	public void insertStudent(Student student) {
		studentDAO.insertStudent(student);
	}

	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}

	public void deleteStudent(Integer studentId) {
		studentDAO.deleteStudent(studentId);
	}

	public Student getStudent(int studentId) {
		return studentDAO.getStudent(studentId);
	}

	public Student updateStudent(Student student) {
		return studentDAO.updateStudent(student);
	}
}
