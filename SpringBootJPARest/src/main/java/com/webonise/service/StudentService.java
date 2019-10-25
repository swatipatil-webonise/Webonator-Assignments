package com.webonise.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webonise.dao.StudentDao;
import com.webonise.model.Student;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	public List<Student> findAll() throws Exception {
		try {
			return (List<Student>) studentDao.findAll();
		} catch (NullPointerException ex) {
			log.info("Students are not selected");
			throw new NullPointerException("Student list is not initialized properly.");
		} catch (Exception ex) {
			log.info("Exception occured while selecting all students from database.");
			throw new Exception("FindAll was unable to excute.", ex);
		}
	}

	public void save(Student student) throws Exception {
		try {
			studentDao.save(student);
		} catch (Exception ex) {
			log.info("Exception occured while inserting student into database.");
			throw new Exception("Save is unable to execute.", ex);
		}
	}

	public Student findById(int id) throws Exception  {
		try {
			return studentDao.findById(id).orElse(null);
		} catch (Exception ex) {
			log.info("Exception occured while selecting single student from database.");
			throw new Exception("FindById was unable to execute.", ex);
		}
	}

	public void deleteById(int id) throws Exception {
		try {
			studentDao.deleteById(id);
		} catch (Exception ex) {
			log.info("Exception occured while deleting student from database.");
			throw new Exception("DeleteById was unable to execute.", ex);
		}
	}

	public int getMax() throws Exception   {
		try {
			return (int) studentDao.count();
		} catch (Exception ex) {
			log.info("Exception occured while getting total count from database.");
			throw new Exception("Check the total number of record in table.", ex);
		}
	}
}
