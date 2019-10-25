package com.webonise.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.webonise.demo.model.Student;
import com.webonise.demo.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/")
	public String getAll(ModelMap model) throws Exception {
		List<Student> list = studentService.findAll();
		model.put("list", list);
		model.put("max", studentService.getMax() + 1);
		return "allStudents.jsp";
	}

	@RequestMapping("/add")
	public ModelAndView addStudent(Student student) throws Exception {
		studentService.save(student);
		return new ModelAndView("redirect:/all");
	}

	@RequestMapping("/get")
	public ModelAndView getStudent(@RequestParam int id) throws Exception {
		return new ModelAndView("update.jsp").addObject(studentService.findById(id));
	}

	@RequestMapping(value = "/update")
	public ModelAndView updateStudent(Student student) throws Exception {
		studentService.deleteById(student.getId());
		studentService.save(student);
		return new ModelAndView("redirect:/all");
	}

	@RequestMapping("/delete")
	public ModelAndView deleteStudent(@RequestParam int id) throws Exception {
		studentService.deleteById(id);
		return new ModelAndView("redirect:/all");
	}
}
