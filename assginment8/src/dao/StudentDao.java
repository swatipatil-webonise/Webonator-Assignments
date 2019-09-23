package dao;

import models.Student;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDao {

    private Connection studentDatabaseConnection;
    private Statement studentDatabaseStatement;
    private ResultSet studentResultSet;
    private final Logger logger;

    public StudentDao() {
        logger = Logger.getAnonymousLogger();
    }

    public void createStudentDatabaseConnection() {
        studentDatabaseConnection = JDBCConnection.getConnection();
    }

    public void getAllStudents() {
        try {
            studentDatabaseStatement = studentDatabaseConnection.createStatement();
            studentResultSet = studentDatabaseStatement.executeQuery("select * from Student");
            System.out.println("Student : ID Name \t    Age ");
            while (studentResultSet.next()) {
                System.out.println("Student : " + studentResultSet.getInt(1) + "\t " + studentResultSet.getString(2) + "\t   " + studentResultSet.getInt(3));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "A sql exception was thrown by getAllStudents():StudentDao class", e);
        } catch (NullPointerException e) {
            logger.log(Level.SEVERE, "A null pointer exception was thrown by getAllStudents():StudentDao class", e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An exception was thrown  by getAllStudents():StudentDao class", e);
        }
    }

    public void insertStudent(Student student) {
        try {
            studentDatabaseStatement = studentDatabaseConnection.prepareStatement("insert into Student values(?,?,?)");
            ((PreparedStatement) studentDatabaseStatement).setInt(1, student.getId());
            ((PreparedStatement) studentDatabaseStatement).setString(2, student.getName());
            ((PreparedStatement) studentDatabaseStatement).setInt(3, student.getAge());
            ((PreparedStatement) studentDatabaseStatement).execute();
            logger.info("1 record inserted.");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "A sql exception was thrown by insertStudent(Student):StudentDao class", e);
        } catch (NullPointerException e) {
            logger.log(Level.SEVERE, "A null pointer exception was thrown by insertStudent(Student):StudentDao class", e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An exception was thrown  by insertStudent(Student):StudentDao class", e);
        }
    }

    public void updateStudent(Student student) {
        try {
            studentDatabaseStatement = studentDatabaseConnection.prepareStatement("update Student set name = ?, age = ? where id = " + student.getId());
            ((PreparedStatement) studentDatabaseStatement).setString(1, student.getName());
            ((PreparedStatement) studentDatabaseStatement).setInt(2, student.getAge());
            ((PreparedStatement) studentDatabaseStatement).execute();
            logger.info("1 record updated.");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "A sql exception was thrown by updateStudent(Student):StudentDao class", e);
        } catch (NullPointerException e) {
            logger.log(Level.SEVERE, "A null pointer exception was thrown by updateStudent(Student):StudentDao class", e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An exception was thrown  by updateStudent(Student):StudentDao class", e);
        }
    }

    public void deleteStudent(int studentId) {
        try {
            studentDatabaseStatement = studentDatabaseConnection.prepareStatement("delete from Student where id = " + studentId);
            ((PreparedStatement) studentDatabaseStatement).execute();
            logger.info("1 record deleted .");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "A sql exception was thrown by deleteStudent(int):StudentDao class", e);
        } catch (NullPointerException e) {
            logger.log(Level.SEVERE, "A null pointer exception was thrown by deleteStudent(int):StudentDao class", e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An exception was thrown  by deleteStudent(int):StudentDao class", e);
        }
    }
}



