package Src.View;

import java.util.Scanner;

public class StudentView {

    private Scanner scanner = new Scanner(System.in);

    public String readStudentId() {
        System.out.println("Enter StudentId :");
        String studentId = scanner.nextLine();

        return studentId;

    }

    public String readStudentName() {
        System.out.println("Enter StudentName :");
        String studentName = scanner.nextLine();

        return studentName;

    }

}