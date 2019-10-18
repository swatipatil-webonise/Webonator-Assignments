package com.webonise.demo.service;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webonise.demo.dao.StudentDao;
import com.webonise.demo.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	private Logger logger = LogManager.getLogManager().getLogger("");

	public List<Student> findAll() throws Exception {
		try {
			return (List<Student>) studentDao.findAll();
		} catch (NullPointerException exception) {
			logger.info("Students are not selected");
			throw new NullPointerException("Student list is not initialized properly.");
		} catch (Exception exception) {
			logger.info("Exception occured while selecting all students from database.");
			throw new Exception("FindAll was unable to excute.", exception);
		}
	}

	public void save(Student student) throws Exception {
		try {
			studentDao.save(student);
		} catch (Exception exception) {
			logger.info("Exception occured while inserting student into database.");
			throw new Exception("Save is unable to execute.", exception);
		}
	}

	public Student findById(int id) throws Exception {
		try {
			return studentDao.findById(id).orElse(null);
		} catch (Exception exception) {
			logger.info("Exception occured while selecting single student from database.");
			throw new Exception("FindById was unable to execute.", exception);
		}
	}

	public void deleteById(int id) throws Exception {
		try {
			studentDao.deleteById(id);
		} catch (Exception exception) {
			logger.info("Exception occured while deleting student from database.");
			throw new Exception("DeleteById was unable to execute.", exception);
		}

	}

	public int getMax() throws Exception {
		try {
			return (int) studentDao.count();
		} catch (Exception exception) {
			logger.info("Exception occured while getting total count from database.");
			throw new Exception("Check the total number of record in table.", exception);
		}
	}
}
