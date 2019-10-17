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

	public List<Student> findAll() {
		List<Student> list = null;
		try {
			list = (List<Student>) studentDao.findAll();
		} catch (NullPointerException exception) {
			logger.info("Students are not selected");
		} catch (Exception exception) {
			logger.info("Exception occured while selecting all students from database.");
		}
		return list;
	}

	public void save(Student student) {
		try {
			studentDao.save(student);
		} catch (Exception exception) {
			logger.info("Exception occured while inserting student into database.");
		}
	}

	public Student findById(int id) {
		Student student = null;
		try {
			student = studentDao.findById(id).orElse(null);
		} catch (Exception exception) {
			logger.info("Exception occured while selecting " + id + "th student from database.");
		}
		return student;
	}

	public void deleteById(int id) {
		try {
			studentDao.deleteById(id);
		} catch (Exception exception) {
			logger.info("Exception occured while deleting " + id + "th student from database.");
		}

	}

	public int getMax() {
		int count = -1;
		try {
			count = (int) studentDao.count();
		} catch (Exception exception) {
			logger.info("Exception occured while getting total count from database.");
		}
		return count;
	}
}
