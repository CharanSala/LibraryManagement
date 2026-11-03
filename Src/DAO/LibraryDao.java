package Src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Src.Model.Book;

import Src.Model.DbConnection;
import Src.Model.Student;

public class LibraryDao {

    public boolean addBook(String bookId, String bookAuthor, String bookName) {

        try {

            String query = "INSERT INTO books (book_id, author, title) VALUES (?, ?, ?)";

            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, bookId);
            ps.setString(2, bookAuthor);
            ps.setString(3, bookName);

            int rows = ps.executeUpdate();

            ps.close();

            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean removeBook(String bookId) {
        try {
            String query = "delete from books where book_id=?";

            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, bookId);

            int rows = ps.executeUpdate();

            ps.close();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Book findBook(String bookId) {

        String query = "SELECT * FROM books WHERE book_id=?";

        try {

            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, bookId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Book book = new Book(rs.getString("book_id"), rs.getString("title"), rs.getString("author"),
                        rs.getString("status"));
                return book;

            }

            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Book> displayAllBooks() {

        ArrayList<Book> books = new ArrayList<>();

        String query = "SELECT * FROM books";

        try {

            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Book book = new Book(rs.getString("book_id"), rs.getString("title"), rs.getString("author"),
                        rs.getString("status"));
                books.add(book);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return books;
    }

    public boolean checkBookStatus(String bookId) {
        String query = "SELECT * FROM books WHERE book_id = ? AND status = ?";

        try {

            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, bookId);
            ps.setString(2, "Available");

            ResultSet rs = ps.executeQuery();

            boolean record = rs.next();

            rs.close();
            ps.close();
            con.close();

            return record;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isStudentExists(String studentId) {
        String query = "SELECT * FROM students WHERE student_id = ?";

        try {

            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, studentId);

            ResultSet rs = ps.executeQuery();

            boolean record = rs.next();

            rs.close();
            ps.close();
            con.close();

            return record;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean assignBookToStudent(String bookId, String studentId) {

        boolean isBookAvailable = checkBookStatus(bookId);
        boolean isStudentExists = isStudentExists(studentId);

        if (!isBookAvailable || !isStudentExists) {
            return false;
        }

        String insertQuery = "INSERT INTO student_books (student_id, book_id) VALUES (?, ?)";
        String updateQuery = "UPDATE books SET status = ? WHERE book_id = ?";

        try {

            Connection con = DbConnection.getConnection();
            PreparedStatement insertPs = con.prepareStatement(insertQuery);

            insertPs.setString(1, studentId);
            insertPs.setString(2, bookId);

            int rows = insertPs.executeUpdate();

            if (rows > 0) {
                PreparedStatement updatePs = con.prepareStatement(updateQuery);

                updatePs.setString(1, "Issued");
                updatePs.setString(2, bookId);

                int updatedRows = updatePs.executeUpdate();

                updatePs.close();
                insertPs.close();
                con.close();

                return updatedRows > 0;
            }

            insertPs.close();
            con.close();

            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean unassignBookFromStudent(String bookId, String studentId) {

        String deleteQuery = "DELETE FROM student_books WHERE book_id = ? AND student_id = ?";
        String updateQuery = "UPDATE books SET status = ? WHERE book_id = ?";

        try {

            Connection con = DbConnection.getConnection();

            PreparedStatement deletePs = con.prepareStatement(deleteQuery);

            deletePs.setString(1, bookId);
            deletePs.setString(2, studentId);

            int rows = deletePs.executeUpdate();

            if (rows > 0) {

                PreparedStatement updatePs = con.prepareStatement(updateQuery);

                updatePs.setString(1, "Available");
                updatePs.setString(2, bookId);

                int updatedRows = updatePs.executeUpdate();

                updatePs.close();
                deletePs.close();
                con.close();

                return updatedRows > 0;
            }

            deletePs.close();
            con.close();

            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
