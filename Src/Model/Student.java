package Src.Model;

import java.util.ArrayList;
import Src.Model.Book;

public class Student {

    private String studentId;
    private String studentName;
    private ArrayList<Book> assignedBooks = new ArrayList<>();

    public Student(String studentId, String studentName, Book book) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.assignedBooks.add(book);

    }

    public String getStudentId() {
        return this.studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public ArrayList<Book> getAssignedBooks() {
        return this.assignedBooks;
    }
}
