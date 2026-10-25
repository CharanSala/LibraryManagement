package Src.Controller;

import Src.View.AuthView;
import Src.View.LibraryView;
import Src.Controller.StudentController;

public class LibraryController {

    private AuthView authView;
    private BookController bookController;
    private LibraryView libraryView;
    private StudentController studentController;

    public LibraryController(AuthView authView, BookController bookController, LibraryView libraryView,
            StudentController studentController) {

        this.authView = authView;
        this.bookController = bookController;
        this.libraryView = libraryView;
        this.studentController = studentController;
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
                    bookController.displayAllBooks();
                    break;
                case 5:
                    bookController.assignBookToStudnet();
                    break;
                case 6:
                    studentController.addStudent();
                    break;
                case 7:
                    studentController.removeStudent();
                    break;
                case 8:
                    studentController.displayAllStudents();
                    break;
                default:
                    System.out.println("Invalid Choice Please try again");

            }

        }

    }
}
