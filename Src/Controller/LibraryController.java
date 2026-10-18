package Src.Controller;

import Src.View.LibraryView;
import Src.Model.AdminDetails;
import Src.View.BookView;
import Src.Model.Book;
import Src.Model.Library;

public class LibraryController {

    private LibraryView libraryView = new LibraryView();
    private AdminDetails admin = new AdminDetails();
    private BookView bookView = new BookView();
    private Library library = new Library();

    private boolean login() {

        String email = libraryView.getEmail();
        String password = libraryView.getPassword();

        String adminEmail = admin.getEmail();
        String adminPassword = admin.getPassword();

        if ((adminEmail == null) || (adminPassword == null))
            libraryView.showMessage("Please register first");

        else if (adminEmail.equals(email) && adminPassword.equals(password)) {
            admin.setToken();
            libraryView.showMessage("Welcome to librarymangemt");
            return true;

        } else {
            libraryView.showMessage("Please Check your email & passwaord");
        }

        return false;

    }

    private void register() {
        String email = libraryView.getEmail();
        String password = libraryView.getPassword();
        if (email == null || password == null) {
            libraryView.showMessage("Please enter valid email and password");
            return;
        }
        admin.setCredentials(email, password);
        libraryView.showMessage("Registered Successfully");

    }

    private void addBook() {
        String bookId = bookView.getBookId();
        String bookAuthor = bookView.getBookAuthor();
        String bookName = bookView.getBookName();

        Book book = new Book(bookId, bookName, bookAuthor, "Available");

        library.addBook(book);

    }

    private void removeBook() {
        String bookId = bookView.getBookId();
        library.removeBook(bookId);
    }

    private void displayMainMenu() {
        libraryView.displayMainMenu();

        int choice = libraryView.getChoice();

        switch (choice) {

            case 1:
                addBook();
                break;
            case 2:
                removeBook();
            default:
                System.out.println("Invalid Choice Please try again");
        }
    }

    public void start() {
        while (true) {
            libraryView.displayEntryMenu();
            int choice = libraryView.getChoice();

            switch (choice) {
                case 1:
                    if (login()) {
                        displayMainMenu();
                        return;
                    }

                    break;
                case 2:
                    register();
                    break;
                case 3:
                    return;

                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }

    }
}
