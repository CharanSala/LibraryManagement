package Src.View;

import java.util.Scanner;

public class LibraryView {

    Scanner scanner = new Scanner(System.in);

    public void displayEntryMenu() {
        System.out.println("1.Login 2.Register");

    }

    public int getChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public String getEmail() {
        System.out.println("Enter you email");
        String email = scanner.nextLine();

        return email;
    }

    public String getPassword() {
        System.out.println("enter your password");
        String password = scanner.nextLine();
        return password;

    }
}
