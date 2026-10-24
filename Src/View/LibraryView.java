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

    public void showMessage(String message) {
        System.out.print("\n");
        System.out.println(message);
    }

    public void displayMainMenu() {
        System.out.println(
                "1.Add Book 2.Remove Book 3.find book byid 4.Display All books 5.Add students 6. remove students 7.display All Students");
    }

}
