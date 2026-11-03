package Src.Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    private static final String url = "jdbc:mysql://localhost:3306/library_management";

    private static final String User = "root";
    private static final String Password = "Charan@081";

    public static Connection getConnection() {
        try {

            Connection con = DriverManager.getConnection(url, User, Password);

            System.out.println("Database Connected Successfully!");

            return con;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }

    }

}