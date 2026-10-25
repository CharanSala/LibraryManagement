package Src.View;

import java.util.Scanner;

import Src.Model.Book;
import Src.Model.Student;

public class StudentView {

    private Scanner scanner = new Scanner(System.in);

    public String readStudentId() {
        System.out.println("Enter StudentId :");
        String studentId = scanner.nextLine();

        return studentId;

    }

    public String readStudentName() {
        System.out.println("Enter StudentName :");
        String studentName = scanner.nextLine();

        return studentName;

    }

    public void displayStudent(Student student) {

        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Student Name: " + student.getStudentName());
        System.out.println("Assigned Books:");

        if (student.getAssignedBooks() == null ||
                student.getAssignedBooks().isEmpty()) {

            System.out.println("No books assigned to this student.");
            return;
        }

        for (Book book : student.getAssignedBooks()) {

            if (book == null) {
                continue;
            }

            System.out.println("Book ID: " + book.getBookId());
            System.out.println("Book Name: " + book.getBookName());
            System.out.println("Book Author: " + book.getBookAuthor());
            System.out.println("Book Status: " + book.getBookStatus());
            System.out.println("----------------------");
        }
    }

}