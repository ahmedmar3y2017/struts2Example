package Services;

import Model.Task;

import java.sql.*;
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
            tasks.add(new Task(rs.getInt("id"), rs.getString("name"), rs.getString("begin"), rs.getString("end"),
                    rs.getString("desc"), rs.getString("manager_name")
            ));
        }

        return tasks;


    }


    // --------- Not Used Yet --------------

    public static Task saveTask(String name, String begin, String end, String desc, String manager_name) throws SQLException, Exception {
        try {

            System.out.println("Name is : " + name);
            String sql = "INSERT INTO task (`name`, `begin` ,`end` ,`desc` , `manager_name`) VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, begin);
            ps.setString(3, end);
            ps.setString(4, desc);
            ps.setString(5, manager_name);
            System.out.println("effected row is : " + ps.executeUpdate());

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {

                    return new Task(generatedKeys.getInt(1), name, begin, end, desc, manager_name, "Succfully saved");

                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return null;
    }


    public static String updateTask(int id, String taskName, String begin, String end, String desc, String manager_name)
            throws SQLException, Exception {
        try {
            String sql = "UPDATE task SET `name`=?,`begin` =?,`end` =?, `desc` =? ,`manager_name` =? WHERE `id`=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, taskName);
            ps.setString(2, begin);
            ps.setString(3, end);
            ps.setString(4, desc);
            ps.setString(5, manager_name);
            ps.setInt(6, id);

            ps.executeUpdate();
            return "Update Successful";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        } finally {
            if (connection != null) {
//                connection.close();
            }
        }
    }

    public static String deleteTask(int id) throws SQLException, Exception {
        try {
            String sql = "DELETE FROM task WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return "Delete Successful";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }


}
