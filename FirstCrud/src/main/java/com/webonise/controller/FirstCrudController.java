package com.webonise.controller;

import com.webonise.model.Student;
import com.webonise.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student-management", produces = {MediaType.APPLICATION_JSON_VALUE})
public class FirstCrudController {

    @Autowired
    private StudentRepository repository;

    public StudentRepository getRepository() {
        return repository;
    }

    public void setRepository(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/students")
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @PostMapping("/students")
    public Student createOrSaveStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    @GetMapping("/students/{id}")
    public Student getStudentByID(@PathVariable int id) {
        return repository.findById(id).get();
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student newStudent, @PathVariable int id) {
        return repository.findById(id).map(student -> {
            student.setId(newStudent.getId());
            student.setAge(newStudent.getAge());
            student.setName(newStudent.getName());
            return repository.save(student);
        }).orElseGet(() -> {
            newStudent.setId(id);
            return repository.save(newStudent);
        });
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        repository.deleteById(id);
    }
}
