package dao;

import models.Student;


import java.sql.*;
import java.util.ArrayList;

public class StudentDao {

    private Connection studentDatabaseConnection;
    private Statement studentDatabaseStatement;
    private ResultSet studentResultSet;

    public void createConnectionAndStatement() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            studentDatabaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_schema", "root", "root");
            studentDatabaseStatement = studentDatabaseConnection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllStudents() {
        Student student = null;
        try {
            studentResultSet = studentDatabaseStatement.executeQuery("select * from table_Student");
            while (studentResultSet.next()) {
                student = new Student(studentResultSet.getInt(1), studentResultSet.getString(2), studentResultSet.getInt(3));
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertStudent(Student student) {
        try {
            studentDatabaseStatement = studentDatabaseConnection.prepareStatement("insert into table_Student values(?,?,?)");
            ((PreparedStatement) studentDatabaseStatement).setInt(1, student.getId());
            ((PreparedStatement) studentDatabaseStatement).setString(2, student.getName());
            ((PreparedStatement) studentDatabaseStatement).setInt(3, student.getAge());
            ((PreparedStatement) studentDatabaseStatement).execute();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void updateStudent(Student student) {
        try {
            studentDatabaseStatement = studentDatabaseConnection.prepareStatement("update table_Student set name = ?, age = ? where id = " + student.getId());
            ((PreparedStatement) studentDatabaseStatement).setString(1, student.getName());
            ((PreparedStatement) studentDatabaseStatement).setInt(2, student.getAge());
            ((PreparedStatement) studentDatabaseStatement).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int studentId) {
        try {
            studentDatabaseStatement = studentDatabaseConnection.prepareStatement("delete from table_Student where id = " + studentId);
            ((PreparedStatement) studentDatabaseStatement).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


