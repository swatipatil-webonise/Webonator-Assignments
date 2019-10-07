package com.webonise.service;

import java.util.List;
import com.webonise.model.Student;

public interface StudentService {
	
	public void insertStudent(Student student);

	public List<Student> getAllStudents();

	public void deleteStudent(Integer studentId);

	public Student getStudent(int studentId);

	public Student updateStudent(Student student);
}
