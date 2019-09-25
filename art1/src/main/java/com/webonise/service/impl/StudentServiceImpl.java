package com.webonise.service.impl;

import com.webonise.entity.Student;
import com.webonise.dao.StudentDao;
import com.webonise.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> listStudents() {
        return studentDao.listStudents();
    }
}
