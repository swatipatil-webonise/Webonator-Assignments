package com.webonise.service;

import com.webonise.model.Student;
import java.util.List;

public interface StudentService {
	
	public void addStudent(Student student);

	public List<Student> getAllStudents();

	public void deleteStudent(Integer studentId);

	public Student getStudent(int studentId);

	public Student updateStudent(Student student);
}
