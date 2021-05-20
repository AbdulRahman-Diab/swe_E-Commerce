package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    
    private static String db_url = "jdbc:mysql://localhost:3306/my_db";
    private static String db_user_name = "root";
    private static String db_password = "root";
    
    public static Connection getConnection() throws SQLException{
        try{
            //creat connectoin 
            Connection connection = DriverManager.getConnection(db_url, db_user_name, db_password);
            return connection;
        }catch(Exception ex){
            System.err.println(ex.toString());
            return null; 
        }
    }    
}
