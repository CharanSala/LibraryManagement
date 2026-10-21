package Src.Model;

public class Student {

    private String studentId;
    private String studentName;

    public Student(String studentId, String StudentName) {
        this.studentId = studentId;
        this.studentName = studentName;

    }

    public String getStudentId() {
        return this.studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }

}
