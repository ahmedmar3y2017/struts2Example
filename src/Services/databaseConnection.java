package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnection {



    private static databaseConnection instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/strutsexample";
    private String username = "root";
    private String password = "root";

    private databaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static databaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new databaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new databaseConnection();
        }

        return instance;
    }


}
