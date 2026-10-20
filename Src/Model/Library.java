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

}
