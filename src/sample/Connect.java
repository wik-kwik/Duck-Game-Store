package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Connect {
    public static final String DRIVER = "org.sqlite.JDBC";
    private Connection conn;
    private Statement stat;

    public Connect() {
        conn = null;
        try {
            Class.forName(Connect.DRIVER);
        } catch (Exception ex) {
            System.err.println("Wymagany sterownik JDBC");
            // handle the error
        }

        try {
            // db parameters
            String url = "jdbc:sqlite:users.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            stat = conn.createStatement();
            System.out.println("Udało się połączyć z bazą danych");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<User> selectUsers() {
        List<User> users = new LinkedList<User>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM users");
            int id;
            String login, passw;
            while (result.next()) {
                id = result.getInt("id_usera");
                login = result.getString("login");
                passw = result.getString("password");
                users.add(new User(login, passw));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return users;
    }

    public boolean insertUser(String login, String passw, String name, String forname){
        try {
            PreparedStatement prepStmt = conn.prepareStatement("insert into users values (NULL, ?, ?, ?, ?);");
            prepStmt.setString(1, login);
            prepStmt.setString(2, passw);
            prepStmt.setString(3, name);
            prepStmt.setString(4, forname);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu usera");
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
