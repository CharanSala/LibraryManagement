package Src.Controller;

import Src.View.StudentView;
import Src.Model.Student;

import java.util.ArrayList;

import Src.Model.Library;
import Src.View.LibraryView;

public class StudentController {

    private StudentView studentView;
    private Library library;
    private LibraryView libraryView;

    public StudentController(StudentView studentView, Library library, LibraryView libraryView) {
        this.studentView = studentView;
        this.library = library;
        this.libraryView = libraryView;
    }

    public void addStudent() {
        String studentId = studentView.readStudentId();
        String studentName = studentView.readStudentName();

        Student student = new Student(studentId, studentName);
        library.addStudent(student);

    }

    public void removeStudent() {
        String studentId = studentView.readStudentId();
        if (library.removeStudent(studentId))
            libraryView.showMessage("Student removed Sucessfully");
        else
            libraryView.showMessage("Student not removed");

    }

    public void displayAllStudents() {
        ArrayList<Student> students = library.displayAllStudents();
        if (students.isEmpty()) {
            studentView.displayStudent(null);
            return;
        }
        for (int i = 0; i < students.size(); i++) {
            studentView.displayStudent(students.get(i));
        }
    }

}
