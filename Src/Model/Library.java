package Src.Model;

import java.util.ArrayList;
import Src.Model.Book;

public class Library {

    private ArrayList<Book> library = new ArrayList<>();

    public void addBook(Book book) {
        library.add(book);
    }

    public boolean removeBook(String bookId) {

        for (int i = 0; i < library.size(); i++) {
            Book book = library.get(i);

            if (book.getBookId().equals(bookId)) {
                library.remove(i);

                return true;
            }
        }
    }

}
