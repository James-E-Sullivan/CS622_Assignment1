package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection conn;
    public static Connection getConnectionToDerby(){
        if(conn == null){
            try{
                //Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                //Get a connection
                conn = DriverManager.getConnection("jdbc:derby:derbyDB;create=true;user=me;password=mine");
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }

        return conn;
    }

    public static void shutdownDerby(){
        try{
            if (conn != null){
                conn.close();
                DriverManager.getConnection("jdbc:derby:derbyDB;shutdown=true;user=me;password=mine");
            }
        }
        catch (SQLException sqlExcept){
            //sqlExcept.printStackTrace();
        }
    }

}
