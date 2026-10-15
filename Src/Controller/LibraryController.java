package Src.Controller;

import Src.View.LibraryView;
import Src.Model.AdminDetails;

public class LibraryController {

    private LibraryView view = new LibraryView();
    private AdminDetails admin = new AdminDetails();

    private void login() {

    }

    private void register() {
        String email = view.getEmail();
        String password = view.getPassword();
        admin.setValues(email, password);

        System.out.println(admin.getEmail());

    }

    public void start() {
        view.displayEntryMenu();
        int choice = view.getChoice();

        if (choice == 1) {
            login();
        }
        if (choice == 2) {
            register();
        }
    }
}
