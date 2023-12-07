package Login;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnection {
    final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final static String DB_URL = "jdbc:mysql://localhost:2301/studentmanagement";
    final static String User = "Tuandaca";
    final static String Pass = "Tuandaca23";

    public static Connection connection(){
        try{
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(DB_URL, User, Pass);
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
