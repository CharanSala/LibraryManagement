package Src.Main;

import Src.Controller.AuthController;
import Src.Controller.BookController;
import Src.Controller.LibraryController;
import Src.Model.AdminAccount;
import Src.Model.Library;
import Src.View.BookView;
import Src.View.AuthView;
import Src.View.LibraryView;
import Src.Controller.StudentController;
import Src.View.StudentView;

class LibraryManagement {
    public static void main(String args[]) {

        Library library = new Library();
        AdminAccount admin = new AdminAccount();
        AuthView authView = new AuthView();
        BookView bookView = new BookView();
        LibraryView libraryView = new LibraryView();
        StudentView studentView = new StudentView();

        BookController bookController = new BookController(bookView, library, libraryView);

        StudentController studentController = new StudentController(studentView, library, libraryView);

        LibraryController libraryController = new LibraryController(authView, bookController, libraryView,
                studentController);
        AuthController authController = new AuthController(authView, admin, libraryController, libraryView);

        authController.start();

    }
}