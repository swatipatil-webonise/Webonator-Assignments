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

	@RequestMapping("/")
	public String getAll(ModelMap model) {
		List<Student> list = studentService.findAll();
		try {
			model.put("list", list);
			int max = studentService.getMax() + 1;
			if (max == -1) {
				logger.info("Max of student is not initialized properly check the database records.");
				return "";
			}
			model.put("max", max);
		} catch (Exception exception) {
			logger.info("Exception occured while updating modeview object in getAll() of controller.");
		}
		return "allStudents.jsp";
	}

	@RequestMapping("/insertStudent")
	public ModelAndView addStudent(Student student) {
		if (student == null) {
			logger.info("Student is not initalized properly while coming through request for insert operation.");
		} else {
			studentService.save(student);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/getStudent")
	public ModelAndView getStudent(@RequestParam int id) {
		ModelAndView model = null;
		try {
			model = new ModelAndView("update.jsp").addObject(studentService.findById(id));
		} catch (Exception exception) {
			logger.info("Exception occured while adding student into modelview object.");
		}
		return model;
	}

	@RequestMapping(value = "/updateStudent")
	public ModelAndView updateStudent(Student student) {
		ModelAndView model = null;
		try {
			if (student == null) {
				logger.info("Student is not initalized properly while coming through request for update operation.");
			} else {
				studentService.deleteById(student.getId());
				studentService.save(student);
				model = new ModelAndView("redirect:/");
			}
		} catch (Exception exception) {
			logger.info("Exception occured while redirecting homepage after update operation from controller.");
		}
		return model;
	}

	@RequestMapping("/deleteStudent")
	public ModelAndView deleteStudent(@RequestParam int id) {
		ModelAndView model = null;
		try {
			studentService.deleteById(id);
			model = new ModelAndView("redirect:/");
		} catch (Exception exception) {
			logger.info("Exception occured while redirecting homepage after delete operation from controller.");
		}
		return model;
	}
}
