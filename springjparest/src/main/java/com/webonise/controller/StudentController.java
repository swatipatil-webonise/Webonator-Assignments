package com.webonise.controller;

import com.webonise.model.Student;
import com.webonise.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @GetMapping(value = "/all-students")
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @PostMapping("/save-student")
    public Student insertStudent(@RequestBody Student student) {
        return studentDao.save(student);
    }

    @GetMapping("/get-student/{id}")
    public Student getStudentByID(@PathVariable int id) {
        return studentDao.findById(id).get();
    }

    @PutMapping("/update-student/{id}")
    public Student updateStudent(@RequestBody Student newStudent, @PathVariable int id) {
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

    @GetMapping("/delete-student/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentDao.deleteById(id);
    }
}
