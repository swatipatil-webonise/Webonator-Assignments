package com.webonise.service;

import com.webonise.dao.StudentDAO;
import com.webonise.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentDAO.deleteStudent(studentId);
    }

    @Override
    public Student getStudent(int studentId) {
        return studentDAO.getStudent(studentId);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentDAO.updateStudent(student);
    }
}
