package com.webonise.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.webonise.model.Student;
import com.webonise.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/")
    public ModelAndView listStudents(ModelAndView model) throws IOException {
        List<Student> listStudent = studentService.getAllStudents();
        model.addObject("listStudent", listStudent);
        model.setViewName("homepage");
        return model;
    }

    @RequestMapping(value = "/enter")
    public ModelAndView enterStudent(ModelAndView model) {
        Student student = new Student();
        model.addObject("student", student);
        model.setViewName("studentDetailsPage");
        return model;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ModelAndView insertStudent(@ModelAttribute Student student) {
          studentService.insertStudent(student);
          return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/delete")
    public ModelAndView deleteStudent(HttpServletRequest request) {
        int studentId = Integer.parseInt(request.getParameter("id"));
        studentService.deleteStudent(studentId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/update")
    public ModelAndView updateStudent(HttpServletRequest request) {
        int studentId = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.getStudent(studentId);
        ModelAndView model = new ModelAndView("studentDetailsPage");
        model.addObject("student", student);
        return model;
    }
}
