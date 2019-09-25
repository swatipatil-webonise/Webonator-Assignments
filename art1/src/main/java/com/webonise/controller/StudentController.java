package com.webonise.controller;

import com.webonise.entity.Student;
import com.webonise.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    public List<Student> listStudents() {
        return studentService.listStudents();
    }
}
