package Src.Controller;

import java.util.ArrayList;

import Src.Model.Book;
import Src.Model.Library;
import Src.View.BookView;
import Src.View.LibraryView;

public class BookController {

    private BookView bookView;
    private Library library;
    private LibraryView libraryView;

    public BookController(BookView bookView, Library library, LibraryView libraryView) {
        this.bookView = bookView;
        this.library = library;
        this.libraryView = libraryView;
    }

    public void addBook() {
        String bookId = bookView.getBookId();
        String bookAuthor = bookView.getBookAuthor();
        String bookName = bookView.getBookName();

        Book book = new Book(bookId, bookName, bookAuthor, "Available");
        library.addBook(book);

        libraryView.showMessage("Book Added Successfully");

    }

    public void removeBook() {
        String bookId = bookView.getBookId();
        library.removeBook(bookId);

        libraryView.showMessage("Book removed succussfully");
    }

    public void findBookById() {
        String bookId = bookView.getBookId();
        Book book = library.findBookById(bookId);
        bookView.displayBook(book);

    }

    public void displayAllBooks() {
        ArrayList<Book> books = library.displayAllBooks();
        for (int i = 0; i < books.size(); i++) {
            bookView.displayBook(books.get(i));
        }

    }

}
