package Src.Model;

public class Book {

    private String bookId;
    private String bookName;
    private String bookAuthor;
    private String bookStatus;

    public Book(String bookId, String bookName, String bookAuthor, String bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookStatus = bookStatus;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void changeStatus() {
        this.bookStatus = "Issued";
    }
}
