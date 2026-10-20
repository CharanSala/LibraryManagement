package Src.Controller;

import Src.View.AuthView;
import Src.Model.AdminAccount;
import Src.Controller.LibraryController;
import Src.View.LibraryView;

public class AuthController {

    private AuthView authView;
    private AdminAccount admin;
    private LibraryController libraryController;
    private LibraryView libraryView;

    public AuthController(AuthView authView, AdminAccount admin, LibraryController libraryController,
            LibraryView libraryView) {
        this.authView = authView;
        this.admin = admin;
        this.libraryController = libraryController;
        this.libraryView = libraryView;
    }

    private boolean login() {

        String email = authView.getEmail();
        String password = authView.getPassword();

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
        String email = authView.getEmail();
        String password = authView.getPassword();
        if (email == null || password == null) {
            libraryView.showMessage("Please enter valid email and password");
            return;
        }
        admin.setCredentials(email, password);
        libraryView.showMessage("Registered Successfully");

    }

    public void start() {
        while (true) {
            libraryView.displayEntryMenu();
            int choice = libraryView.getChoice();

            switch (choice) {
                case 1:
                    if (login()) {
                        libraryController.start();
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
