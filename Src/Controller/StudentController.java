package Src.Controller;

import Src.View.StudentView;
import Src.Model.Student;

import java.util.ArrayList;

import Src.Model.Library;
import Src.View.LibraryView;
import Src.DAO.StudentDao;

public class StudentController {

    private StudentView studentView;
    private Library library;
    private LibraryView libraryView;
    private StudentDao studentDao = new StudentDao();

    public StudentController(StudentView studentView, Library library, LibraryView libraryView) {
        this.studentView = studentView;
        this.library = library;
        this.libraryView = libraryView;
    }

    public void addStudent() {
        String studentId = studentView.readStudentId();
        String studentName = studentView.readStudentName();

        if (studentId == null || studentName == null) {
            libraryView.showMessage("Please enter student details");
            return;
        }

        try {
            boolean isStudentadded = studentDao.addStudent(studentId, studentName);

            if (isStudentadded)
                libraryView.showMessage("Student added sucessfully");
            else {
                libraryView.showMessage("Unable to add student");
            }
        } catch (Exception e) {
            libraryView.showMessage("Database error while creating the student");
            e.printStackTrace();
        }

    }

    public void removeStudent() {
        String studentId = studentView.readStudentId();

        if (studentId == null) {
            libraryView.showMessage("Please enter a valid student ID");
            return;
        }

        try {
            boolean isStudentremoved = studentDao.removeStudent(studentId);

            if (isStudentremoved)
                libraryView.showMessage("Studnet removed Sucessfully");
            else
                libraryView.showMessage("Student not removed");
        } catch (Exception e) {
            libraryView.showMessage("Database error while removing the student");
        }

    }

    public void displayAllStudents() {
        ArrayList<Student> students = studentDao.displayAllStudents();
        if (students.isEmpty()) {
            studentView.displayStudent(null);
            return;
        }
        for (int i = 0; i < students.size(); i++) {
            studentView.displayStudent(students.get(i));
        }
    }

}
