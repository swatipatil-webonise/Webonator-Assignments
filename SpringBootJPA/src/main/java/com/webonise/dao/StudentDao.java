package com.webonise.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webonise.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{

}
