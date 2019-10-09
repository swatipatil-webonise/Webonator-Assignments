package com.webonise.controller;

import com.webonise.model.Student;
import com.webonise.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/insert")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/get/{id}")
    public Student getStudentByID(@PathVariable int id) {
        return studentService.getStudentByID(id);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student newStudent) {
        return studentService.updateStudent(newStudent);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }
}
