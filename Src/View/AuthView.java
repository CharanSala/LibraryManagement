package Src.View;

import java.util.Scanner;

public class AuthView {

    private Scanner scanner = new Scanner(System.in);

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
