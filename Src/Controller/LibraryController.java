package Src.Controller;

import Src.View.AuthView;
import Src.View.LibraryView;

public class LibraryController {

    private AuthView authView;

    private BookController bookController;
    private LibraryView libraryView;

    public LibraryController(AuthView authView, BookController bookController, LibraryView libraryView) {

        this.authView = authView;
        this.bookController = bookController;
        this.libraryView = libraryView;
    }

    void start() {

        while (true) {
            libraryView.displayMainMenu();

            int choice = libraryView.getChoice();

            switch (choice) {

                case 1:
                    bookController.addBook();
                    break;
                case 2:
                    bookController.removeBook();
                    break;
                case 3:
                    bookController.findBookById();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid Choice Please try again");

            }

        }

    }
}
