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

    @RequestMapping(value = "/enterStudent", method = RequestMethod.GET)
    public ModelAndView enterStudent(ModelAndView model) {
        Student student = new Student();
        model.addObject("student", student);
        model.setViewName("studentDetailsPage");
        return model;
    }

    @RequestMapping(value = "/insertStudent", method = RequestMethod.POST)
    public ModelAndView insertStudent(@ModelAttribute Student student) {
        if (student.getId() == 0) {
            studentService.insertStudent(student);
        } else {
            studentService.updateStudent(student);
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
    public ModelAndView deleteStudent(HttpServletRequest request) {
        int studentId = Integer.parseInt(request.getParameter("id"));
        studentService.deleteStudent(studentId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.GET)
    public ModelAndView updateStudent(HttpServletRequest request) {
        int studentId = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.getStudent(studentId);
        ModelAndView model = new ModelAndView("studentDetailsPage");
        model.addObject("student", student);
        return model;
    }
}
