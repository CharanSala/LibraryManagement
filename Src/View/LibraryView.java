package Src.View;

import java.util.Scanner;

public class LibraryView {

    private Scanner scanner = new Scanner(System.in);

    public void displayEntryMenu() {
        System.out.println("1.Login 2.Register 3.Exit");

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

    public void showMessage(String message) {
        System.out.print("\n");
        System.out.println(message);
    }

    public void displayMainMenu() {
        System.out.println("1.Add Book 2.Remove Book 3.Display Book 4.Add Student");
    }

}
