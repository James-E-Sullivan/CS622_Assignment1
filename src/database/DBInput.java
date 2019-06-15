package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//https://db.apache.org/derby/integrate/plugin_help/derby_app.html

public class DBInput {

    private static Statement stmt;
    private static String tableName = "allParcels";

    public static void init(){
        // create table
        try(Statement myStmt = ConnectionFactory.getConnectionToDerby().createStatement()){
            myStmt.execute("drop table " + tableName);
            myStmt.execute("create table " + tableName + "(PID varchar(10), address varchar(100), type varchar(100))");
            System.out.println("Created table location");
        }
        catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    }

    public static void insert (String PID, String address, String type){
        try (Statement myStmt = ConnectionFactory.getConnectionToDerby().createStatement()){
            myStmt.execute("insert into " + tableName + " values (" + "'" + PID + "'" + ",'"
                    + address + "','" + type + "')");
        }
        catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    }

    public static void select(){
        try(Statement myStmt = ConnectionFactory.getConnectionToDerby().createStatement();
            ResultSet results = myStmt.executeQuery("select * from " + tableName);
        ){
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++){
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i) + "\t\t");
            }

            System.out.println("\n--------------------------------------------------");

            while(results.next()){
                String PID = results.getString(1);
                String address = results.getString(2);
                String type = results.getString(3);
                System.out.println(PID + "\t\t" + address + "\t\t" + type);
            }

        }
        catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    }




}
