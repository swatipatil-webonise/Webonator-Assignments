package com.webonise.dao;

import com.webonise.model.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addStudent(Student student) {
        sessionFactory.getCurrentSession().saveOrUpdate(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return sessionFactory.getCurrentSession().createQuery("from Student")
                .list();
    }

    @Override
    public void deleteStudent(Integer studentId) {
        Student student = (Student) sessionFactory.getCurrentSession().load(
                Student.class, studentId);
        if (null != student) {
            this.sessionFactory.getCurrentSession().delete(student);
        }
    }

    @Override
    public Student getStudent(int studentId) {
        return (Student) sessionFactory.getCurrentSession().get(
                Student.class, studentId);
    }

    @Override
    public Student updateStudent(Student student) {
        sessionFactory.getCurrentSession().update(student);
        return student;
    }
}
