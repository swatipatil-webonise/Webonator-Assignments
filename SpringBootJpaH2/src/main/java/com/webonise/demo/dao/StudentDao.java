package com.webonise.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.webonise.demo.model.Student;

public interface StudentDao extends CrudRepository<Student, Integer>{

}
