package Src.View;

import java.util.Scanner;
import Src.Model.Book;

public class BookView {

    private Scanner scanner = new Scanner(System.in);

    public String getBookId() {
        System.out.println("Enter book ID:");
        String bookId = scanner.nextLine();

        return bookId;

    }

    public String getBookName() {
        System.out.println("Enter book name:");
        String bookName = scanner.nextLine();

        return bookName;

    }

    public String getBookAuthor() {
        System.out.println("Enter book author:");
        String bookAuthor = scanner.nextLine();

        return bookAuthor;

    }

    public void displayBook(Book book) {
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        System.out.println("Book ID: " + book.getBookId());
        System.out.println("Book Name: " + book.getBookName());
        System.out.println("Book Author: " + book.getBookAuthor());
        System.out.println("Book Status: " + book.getBookStatus());
    }

}
