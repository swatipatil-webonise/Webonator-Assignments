package com.webonise.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.webonise.model.Student;
import com.webonise.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/students")
@Api(value="Student-Management-System")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@ApiOperation(value = "View a list of available students")
	@GetMapping(path = "/")
	public List<Student> getAllStudents() throws Exception {
		return studentService.findAll();
	}
	
	@ApiOperation(value = "Get student by his/her id")
	@GetMapping("/get/{id}")
	public Student getStudent(@PathVariable("id") int id) throws Exception {
		return studentService.findById(id);
	}
	
	@ApiOperation(value = "Add new Student")
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) throws Exception {
		studentService.save(student);
		return student;
	}
	
	@ApiOperation(value = "Update existing student")
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) throws Exception {
		studentService.save(student);
		return student;
	}
	
	@ApiOperation(value = "Delete student by his/her id")
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) throws Exception {
		studentService.deleteById(id);
		return "deleted";
	}
}
