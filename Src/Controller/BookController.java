package Src.Controller;

import java.util.ArrayList;

import Src.Model.Book;
import Src.Model.Library;
import Src.View.BookView;
import Src.View.LibraryView;
import Src.View.StudentView;
import Src.DAO.LibraryDao;

public class BookController {

    private BookView bookView;
    private Library library;
    private LibraryView libraryView;
    private StudentView studentView = new StudentView();
    private LibraryDao libraryDao = new LibraryDao();

    public BookController(BookView bookView, Library library, LibraryView libraryView) {
        this.bookView = bookView;
        this.library = library;
        this.libraryView = libraryView;
    }

    public void addBook() {
        String bookId = bookView.getBookId();
        String bookAuthor = bookView.getBookAuthor();
        String bookName = bookView.getBookName();

        if (bookId == null || bookAuthor == null || bookName == null) {
            libraryView.showMessage("Please enter all book details");
            return;
        }

        try {
            boolean isBookCreated = libraryDao.addBook(bookId, bookAuthor, bookName);

            if (isBookCreated)
                libraryView.showMessage("Book Added Successfully");
            else
                libraryView.showMessage("Book Already Exists");
        } catch (Exception e) {
            libraryView.showMessage("Database error while adding book");
            e.printStackTrace();
        }

    }

    public void removeBook() {
        String bookId = bookView.getBookId();

        if (bookId == null) {
            libraryView.showMessage("Please enter Book ID");
            return;
        }
        try {
            boolean isRemove = libraryDao.removeBook(bookId);

            if (isRemove)
                libraryView.showMessage("Book removed succussfully");
            else
                libraryView.showMessage("Something wrong Book not removed");
        } catch (Exception e) {
            libraryView.showMessage("Database error while removing book");
            e.printStackTrace();
        }

    }

    public void findBookById() {
        String bookId = bookView.getBookId();

        if (bookId == null) {
            libraryView.showMessage("Please enter Book ID");
            return;
        }

        try {
            Book book = libraryDao.findBook(bookId);

            if (book != null) {
                bookView.displayBook(book);
            } else {
                libraryView.showMessage("Book not found");
            }
        } catch (Exception e) {
            libraryView.showMessage("Database error while finding book");
            e.printStackTrace();
        }

    }

    public void displayAllBooks() {
        try {
            ArrayList<Book> books = libraryDao.displayAllBooks();
            if (books.isEmpty()) {
                libraryView.showMessage("No books available");
                return;
            }

            for (int i = 0; i < books.size(); i++) {
                bookView.displayBook(books.get(i));
            }
        } catch (Exception e) {
            libraryView.showMessage("Database error while fetching books");
            e.printStackTrace();
        }
    }

    public void assignBookToStudnet() {
        String bookId = bookView.getBookId();
        String studentId = studentView.readStudentId();

        if (bookId == null || studentId == null) {
            libraryView.showMessage("Please enter both Book ID and Student ID");
            return;
        }

        try {

            boolean isBookAssigned = libraryDao.assignBookToStudent(bookId, studentId);

            if (isBookAssigned) {
                libraryView.showMessage("Book assigned successfully");
            } else {
                libraryView.showMessage("Book not assigned. Check book availability or student ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            libraryView.showMessage("Database error while assigning the book");
        }

    }

    public void unassignBookToStudnet() {
        String bookId = bookView.getBookId();
        String studentId = studentView.readStudentId();

        if (bookId == null || studentId == null) {
            libraryView.showMessage("Please enter both Book ID and Student ID");
            return;
        }
        try {

            boolean isBookUnassigned = libraryDao.unassignBookFromStudent(bookId, studentId);
            if (isBookUnassigned) {
                libraryView.showMessage("Book unassigned successfully");
            } else {
                libraryView.showMessage("No matching book assignment found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            libraryView.showMessage("Database error while unassigning the book");
        }
    }

}
