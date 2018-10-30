package Services;

import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class signUpTransactions {

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

    public static int insertIntoUser(User user) throws SQLException {



        // create the java statement
        PreparedStatement st = connection.prepareStatement("insert into user (`name` , `email` , `password` , `address` , `phone`) values" +
                " ('" + user.getName() + "' , '" + user.getEmail() + "' , '" + user.getPassword() + "'  , '" + user.getAddress() + "' , '" + user.getPhone() + "')");

        return st.executeUpdate();


    }


}
