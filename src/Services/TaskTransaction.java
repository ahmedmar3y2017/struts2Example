package Services;

import Model.Task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskTransaction {
    static databaseConnection databaseConnection;
    static Connection connection;

    static {
        try {
            databaseConnection = Services.databaseConnection.getInstance();
            connection = databaseConnection.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void insertTask() {


    }

    public static List<Task> getAllTasks() throws SQLException {

        List<Task> tasks = new ArrayList<>();
        // if you only need a few columns, specify them by name instead of using "*"
        String query = "SELECT * FROM task";

        // create the java statement
        Statement st = connection.createStatement();

        // execute the query, and get a java resultset
        ResultSet rs = st.executeQuery(query);

        // iterate through the java resultse
        while (rs.next()) {
            tasks.add(new Task(rs.getString("name"), rs.getDate("begin"), rs.getDate("end"),
                    rs.getString("desc"), rs.getString("manager_name")
            ));
        }

        return tasks;


    }


}
