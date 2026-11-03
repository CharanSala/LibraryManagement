package Src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Src.Model.DbConnection;
import Src.Model.Student;

public class StudentDao {

    public boolean addStudent(String studentId, String studentName) {

        String query = "INSERT INTO students (student_id, student_name) VALUES (?, ?)";

        try {

            Connection con = DbConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, studentId);
            ps.setString(2, studentName);

            int rows = ps.executeUpdate();

            con.close();
            ps.close();

            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }

    }

    public boolean removeStudent(String studentId) {

        String query = "delete from students where student_id=?";

        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, studentId);

            int rows = ps.executeUpdate();

            con.close();
            ps.close();

            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Student> displayAllStudents() {

        ArrayList<Student> students = new ArrayList<>();

        String query = "SELECT * FROM students";

        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String studentId = rs.getString("student_id");
                String studentName = rs.getString("student_name");

                Student student = new Student(studentId, studentName, null);

                students.add(student);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

}
