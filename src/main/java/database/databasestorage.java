package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databasestorage {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/weatherapp_db";
        String username = "root";
        String password = "arsol1997";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
