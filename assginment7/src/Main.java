import dao.StudentDao;
import models.Student;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        studentDao.createConnectionAndStatement();
        studentDao.insertStudent(new Student(4,"Sanjay",25));
        studentDao.updateStudent(new Student(3,"Shankar",25));
        studentDao.deleteStudent(4);
        studentDao.getAllStudents();
    }
}

