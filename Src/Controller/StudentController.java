package Src.Controller;

import Src.View.StudentView;
import Src.Model.Student;
import Src.Model.Library;
import Src.View.LibraryView;

public class StudentController {

    private StudentView studentView = new StudentView();
    private Library library = new Library();
    private LibraryView libraryView = new LibraryView();

    public void addStudent() {
        String studentId = studentView.readStudentId();
        String studentName = studentView.readStudentName();

        Student student = new Student(studentId, studentName);
        library.addStudent(student);

    }

    public void removeStudent() {
        String studentId = studentView.readStudentId();
        boolean status = library.removeStudent(studentId);
        libraryView.showMessage("Student removed Sucessfully");

    }

}
