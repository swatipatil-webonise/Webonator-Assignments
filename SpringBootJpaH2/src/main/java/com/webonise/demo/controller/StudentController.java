package com.webonise.demo.controller;

import java.util.List;

import java.util.logging.LogManager;
import java.util.logging.Logger;
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

	private Logger logger = LogManager.getLogManager().getLogger("");

	@RequestMapping("/all")
	public String getAll(ModelMap model) {
		try {
			List<Student> list = studentService.findAll();
			model.put("list", list);
			model.put("max", studentService.getMax() + 1);
		} catch (Exception exception) {
			logger.info("Exception occured while updating modeview object in getAll() of controller.");
		}
		return "allStudents.jsp";
	}

	@RequestMapping("/add")
	public ModelAndView addStudent(Student student) {
		try {
			studentService.save(student);
		} catch (NullPointerException exception) {
			logger.info("Student coming from request might not have been initailized.");
		} catch (Exception exception) {
			logger.info("StudentController is not able to perform save operation.");
		}
		return new ModelAndView("redirect:/all");
	}

	@RequestMapping("/get")
	public ModelAndView getStudent(@RequestParam int id) {
		ModelAndView model = null;
		try {
			model = new ModelAndView("update.jsp").addObject(studentService.findById(id));
		} catch (Exception exception) {
			logger.info("Exception occured while adding student into modelview object.");
		}
		return model;
	}

	@RequestMapping(value = "/update")
	public ModelAndView updateStudent(Student student) {
		try {
			studentService.deleteById(student.getId());
			studentService.save(student);
		} catch (NullPointerException exception) {
			logger.info("Student is not initalized properly while coming through request for update operation.");
		} catch (Exception exception) {
			logger.info("Exception occured while redirecting homepage after update operation from controller.");
		}
		return new ModelAndView("redirect:/all");
	}

	@RequestMapping("/delete")
	public ModelAndView deleteStudent(@RequestParam int id) {
		try {
			studentService.deleteById(id);
		} catch (Exception exception) {
			logger.info("Exception occured while redirecting homepage after delete operation from controller.");
		}
		return new ModelAndView("redirect:/all");
	}
}
