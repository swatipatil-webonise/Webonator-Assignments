package com.webonise.controller;

import com.webonise.model.Student;
import com.webonise.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/allStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/insertStudent")
    public Student createOrSaveStudent(@RequestBody Student student) {
        return studentService.createOrSaveStudent(student);
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudentByID(@PathVariable int id) {
        return studentService.getStudentByID(id);
    }

    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@RequestBody Student newStudent, @PathVariable int id) {
        return studentService.getStudent(newStudent, id);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }
}
