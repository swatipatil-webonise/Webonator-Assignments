package com.webonise.service;

import com.webonise.model.Student;
import com.webonise.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    public Student createOrSaveStudent(Student student) {
        return studentDao.save(student);
    }

    public Student getStudentByID(int id) {
        return studentDao.findById(id).get();
    }

    public Student getStudent(Student newStudent, int id) {
        return studentDao.findById(id).map(student -> {
            student.setId(newStudent.getId());
            student.setAge(newStudent.getAge());
            student.setName(newStudent.getName());
            return studentDao.save(student);
        }).orElseGet(() -> {
            newStudent.setId(id);
            return studentDao.save(newStudent);
        });
    }

    public void deleteStudent(int id) {
        studentDao.deleteById(id);
    }
}
