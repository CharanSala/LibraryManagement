package Src.Controller;

import Src.View.AuthView;
import Src.Model.AdminAccount;
import Src.Controller.LibraryController;
import Src.View.LibraryView;
import Src.DAO.AdminDao;

public class AuthController {

    private AuthView authView;
    private AdminAccount admin;
    private LibraryController libraryController;
    private LibraryView libraryView;

    private AdminDao adminDao = new AdminDao();

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

        if (email == null || password == null) {

            libraryView.showMessage("Please enter email and password");
            return false;
        }

        try {
            String adminEmail = adminDao.login(email, password);

            if (adminEmail != null) {
                admin.setEmail(adminEmail);
                libraryView.showMessage("Login successful");
                return true;

            } else {
                libraryView.showMessage("Please Check your email or1 passwaord");
                return false;
            }
        }

        catch (Exception e) {
            libraryView.showMessage("Database error. Please try again later.");
            e.printStackTrace();
            return false;
        }
    }

    private void register() {
        String email = authView.getEmail();
        String password = authView.getPassword();
        if (email == null || password == null) {
            libraryView.showMessage("Please enter valid email and password");
            return;
        }
        try {
            boolean isRegistered = adminDao.register(email, password);
            if (isRegistered) {
                libraryView.showMessage("Registered Successfully");
            } else {
                libraryView.showMessage("Registration Failed");
            }
        } catch (Exception e) {
            libraryView.showMessage("Database error during registration");
            e.printStackTrace();

        }

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
