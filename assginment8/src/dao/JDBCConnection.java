package dao;

import sun.security.util.Password;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/college_schema";
    private static final String PASSWORD = "root";
    private static final String USERNAME = "root";
    private static final Logger logger = Logger.getAnonymousLogger();
    private static Connection connection;

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL , USERNAME , PASSWORD );
            return connection;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "A sql exception was thrown by getConnection():JDBCConnection class", e);
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "A classNotFoundException was thrown by getConnection():JDBCConnection class", e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An exception was thrown by getConnection():JDBCConnection class", e);
        }
        return connection;
    }
}

