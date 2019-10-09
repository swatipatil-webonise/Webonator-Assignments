package com.webonise.service;

import com.webonise.model.Student;
import com.webonise.repository.StudentDao;
import jdk.internal.instrumentation.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.LogManager;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    private Logger logger = (Logger) LogManager.getLogManager().getLogger("logger");

    public List<Student> getAllStudents() {
        try {
            return studentDao.findAll();
        } catch(Exception e) {
            logger.error("Exception occurred at getAllStudents() in StudentService.class.", e);
        }
        return null;
    }

    public Student saveStudent(Student student) {
        try {
            return studentDao.save(student);
        } catch(Exception e) {
            logger.error("Exception occurred at saveStudent() in StudentService.class.", e);
        }
        return null;
    }

    public Student getStudentByID(int id) {
        try {
            return studentDao.findById(id).get();
        } catch(Exception e) {
            logger.error("Exception occurred at getStudentById() in StudentService.class.", e);
        }
        return null;
    }

    public Student updateStudent(Student newStudent) {
        try {
            return studentDao.findById(newStudent.getId()).map(student -> {
                student.setId(newStudent.getId());
                student.setAge(newStudent.getAge());
                student.setName(newStudent.getName());
                return studentDao.save(student);
            }).orElseGet(() -> {
                newStudent.setId(newStudent.getId());
                return studentDao.save(newStudent);
            });
        } catch(Exception e) {
            logger.error("Exception occurred at getStudentById() in StudentService.class.", e);
        }
        return null;
    }

    public void deleteStudent(int id) {
        try {
            studentDao.deleteById(id);
        } catch(Exception e) {
            logger.error("Exception occurred at getStudentById() in StudentService.class.", e);
        }
    }
}
