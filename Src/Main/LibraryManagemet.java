package Src.Main;

import Src.Controller.AuthController;
import Src.Controller.BookController;
import Src.Controller.LibraryController;
import Src.Model.AdminDetails;
import Src.Model.Library;
import Src.View.BookView;
import Src.View.AuthView;
import Src.View.LibraryView;

class LibraryManagement {
    public static void main(String args[]) {

        Library library = new Library();
        AdminDetails admin = new AdminDetails();
        AuthView authView = new AuthView();
        BookView bookView = new BookView();
        LibraryView libraryView = new LibraryView();

        BookController bookController = new BookController(bookView, library, libraryView);

        LibraryController libraryController = new LibraryController(authView, bookController, libraryView);
        AuthController authController = new AuthController(authView, admin, libraryController, libraryView);
        authController.start();

    }
}