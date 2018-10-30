package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class loginTransactions {


   static databaseConnection databaseConnection;
    static  Connection connection ;
    static {
        try {
            databaseConnection = Services.databaseConnection.getInstance();
             connection= databaseConnection.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public loginTransactions() throws SQLException {
    }

    public static boolean login(String email , String password) throws SQLException {

        // if you only need a few columns, specify them by name instead of using "*"
        String query = "SELECT * FROM user where email='"+email+"' and password='"+password+"'";

        // create the java statement
        Statement st = connection.createStatement();

        // execute the query, and get a java resultset
        ResultSet rs = st.executeQuery(query);

        // iterate through the java resultse
       if(rs.next()){
         return  true;

       }else
       {
           return false;
       }

    }


}
