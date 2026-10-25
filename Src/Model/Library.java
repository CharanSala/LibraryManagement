package Src.Model;

import java.util.ArrayList;
import Src.Model.Book;
import Src.Model.Student;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(String bookId) {

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);

            if (book.getBookId().equalsIgnoreCase(bookId)) {
                books.remove(i);

                return true;
            }
        }
        return false;
    }

    public Book findBookById(String bookId) {
        Book book;
        for (int i = 0; i < books.size(); i++) {
            book = books.get(i);
            if (book.getBookId().equalsIgnoreCase(bookId)) {
                return book;
            }
        }

        return null;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean removeStudent(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getStudentId().equals(studentId)) {
                students.remove(i);
                return true;
            }
        }
        return false;

    }

    public ArrayList<Book> displayAllBooks() {
        return books;
    }

    public ArrayList<Student> displayAllStudents() {
        return students;
    }

    public Book checkBookStatus(String bookId) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getBookStatus().equalsIgnoreCase("Available")) {
                return books.get(i);
            }
        }
        return null;
    }

    public Student checkStudent(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getStudentId().equals(studentId)) {
                return students.get(i);
            }
        }
        return null;
    }

    public void assignBookToStudent(String bookId, String studentId) {
        Book book = checkBookStatus(bookId);
        Student student = checkStudent(studentId);

        if (book != null && student != null) {
            book.changeStatus();
            student.getAssignedBooks().add(book);
        }
    }

}
