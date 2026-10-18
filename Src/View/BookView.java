package Src.View;

import java.util.Scanner;

public class BookView {

    Scanner scanner = new Scanner(System.in);

    public String getBookId() {
        System.out.println("Enter the bookId");
        String bookId = scanner.nextLine();

        return bookId;

    }

    public String getBookName() {
        System.out.println("Enter the bookName");
        String bookName = scanner.nextLine();

        return bookName;

    }

    public String getBookAuthor() {
        System.out.println("Enter the book Author");
        String bookAuthor = scanner.nextLine();

        return bookAuthor;

    }

}
