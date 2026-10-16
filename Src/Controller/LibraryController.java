package Src.Controller;

import Src.View.LibraryView;
import Src.Model.AdminDetails;

public class LibraryController {

    private LibraryView view = new LibraryView();
    private AdminDetails admin = new AdminDetails();

    private boolean login() {

        String email = view.getEmail();
        String password = view.getPassword();

        String adminEmail = admin.getEmail();
        String adminPassword = admin.getPassword();

        if ((adminEmail == null) || (adminPassword == null))
            view.showMessage("Please register first");

        else if (adminEmail.equals(email) && adminPassword.equals(password)) {
            admin.setToken();
            view.showMessage("Welcome to librarymangemt");
            return true;

        } else {
            view.showMessage("Please Check your email & passwaord");
        }

        return false;

    }

    private void register() {
        String email = view.getEmail();
        String password = view.getPassword();
        if (email == null || password == null) {
            view.showMessage("Please enter valid email and password");
            return;
        }
        admin.setCredentials(email, password);
        view.showMessage("Registered Successfully");

    }

    private void displayMainMenu() {
        view.displayMainMenu();
    }

    public void start() {
        while (true) {
            view.displayEntryMenu();
            int choice = view.getChoice();

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
