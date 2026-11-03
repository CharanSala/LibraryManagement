package Src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Src.Model.DbConnection;

public class AdminDao {

    public boolean register(String email, String password) {
        String query = "INSERT INTO users (email, password_hash) VALUES (?, ?)";

        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String login(String email, String password) {
        String query = "select id,email from users where email=? and password_hash =?";
        try {
            Connection con = DbConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            boolean isLogin = rs.next();
            String adminEmail = isLogin ? rs.getString("email") : null;

            rs.close();
            ps.close();
            con.close();

            if (isLogin)
                return adminEmail;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }
}
