package com.webonise.dao;

import java.util.List;
import com.webonise.model.Student;

public interface StudentDAO {

	public void insertStudent(Student student);

	public List<Student> getAllStudents();

	public void deleteStudent(Integer studentId);

	public Student updateStudent(Student student);

	public Student getStudent(int studentId);
}
