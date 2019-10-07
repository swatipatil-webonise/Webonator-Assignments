package com.webonise.controller;

import com.webonise.model.Student;
import com.webonise.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping(value = "/student-management", produces = {MediaType.APPLICATION_JSON_VALUE})
public class FirstCrudController {

    @Autowired
    private StudentRepository repository;

    public StudentRepository getRepository() {
        return repository;
    }

    public void setRepository(StudentRepository repository) {
        this.repository = repository;
    }

   /* @GetMapping(value = "/students")
    public List<Student> getAllStudents() {
        return repository.findAll();
    }*/




    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listEmployees(ModelMap map) {

        map.addAttribute("student", new Student());
        map.addAttribute("studentList", repository.findAll());

        return "editStudentList";
    }

    @RequestMapping("/delete{id}")
    public String deleteStudent(@PathVariable int id) {
        repository.deleteById(id);
        return "redirect: /list";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployee(
            @ModelAttribute(value = "student") Student student,
            BindingResult result) {
        repository.save(student);
        return "redirect: /list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute(value = "student") Student student , BindingResult result) {
        repository.save(student);
        return "redirect: /list";
    }














   /* @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute("product") Product product) {
        productService.update(product);
        return "product/success";
    }*/





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


}
