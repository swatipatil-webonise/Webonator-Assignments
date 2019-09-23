import dao.JDBCConnection;
import dao.StudentDao;
import models.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentJDBCApp {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentDao studentDao = new StudentDao();

    public static void main(String[] args) {
        int dbOperationChoice = 0;
        studentDao.createStudentDatabaseConnection();
        char continueOrNot = 'y';
        do {
            System.out.println("Choose your database operation :\n1. View Student table \n2. Insert student \n3. Update Student \n4. Delete student");
            dbOperationChoice = scanner.nextInt();
            switch (dbOperationChoice) {
                case 1 : studentDao.getAllStudents();
                    break;
                case 2 : System.out.println("How many students you want to insert : ");
                    int numberOfStudentsToBeInserted = scanner.nextInt();
                    for(int insertionCounter=0;insertionCounter<numberOfStudentsToBeInserted;insertionCounter++) {
                        System.out.println("Enter the Id , name and age of student " + (insertionCounter+1) + " to be inserted :");
                        Student student = new Student(scanner.nextInt(), scanner.next(), scanner.nextInt());
                        studentDao.insertStudent(student);
                    }
                    break;
                case 3 :
                    System.out.println("How many students you want to update : ");
                    int numberOfStudentsToBeUpdated = scanner.nextInt();
                    for(int updationCounter=0;updationCounter<numberOfStudentsToBeUpdated;updationCounter++) {
                        System.out.println("Enter the Id and values of name and age of the student " + (updationCounter+1) + " to be updated :");
                        Student student = new Student(scanner.nextInt(), scanner.next(), scanner.nextInt());
                        studentDao.updateStudent(student);
                    }
                    break;
                case 4 :
                    System.out.println("How many students you want to delete : ");
                    int numberOfStudentsToBeDeleted = scanner.nextInt();
                    for(int deletionCounter=0;deletionCounter<numberOfStudentsToBeDeleted;deletionCounter++) {
                        System.out.println("Enter the Id of the student " + (deletionCounter+1) + " to be deleted :");
                        studentDao.deleteStudent(scanner.nextInt());
                    }
                    break;
                default:
                    System.out.println("Sorry operation is invalid");
            }
            System.out.println("Do you want to perform any other operation :(y/n)");
            continueOrNot = scanner.next().charAt(0);
        } while (continueOrNot == 'y');
    }
}


