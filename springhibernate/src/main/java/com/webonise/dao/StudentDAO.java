package com.webonise.dao;

import com.webonise.model.Student;
import java.util.List;

public interface StudentDAO {

    public void addStudent(Student student);

    public List<Student> getAllStudents();

    public void deleteStudent(Integer studentId);

    public Student updateStudent(Student student);

    public Student getStudent(int studentId);
}
