package database;

import mail_packages.MailPackage;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class PackageTableSQL {

    // default constructor
    public PackageTableSQL(String name){tableName = name;}

    private static Statement stmt;

    private static String tableName;

    public void init(){

        try(Statement myStmt = ConnectionFactory.getConnectionToDerby().createStatement()){
            myStmt.execute("drop table " + tableName);
            myStmt.execute("create table " + tableName + "(shipper varchar(15), origination varchar(100)," +
                    " address varchar(100), weight double, PID varchar(15) )");
            System.out.println("Created Package Table");
        }
        catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    }

    public void insert (MailPackage mp){

        String insertString = "insert into " + tableName + " values ('" +
                mp.getShipper() + "','" +
                mp.getOrigination() + "','" +
                mp.getAddress() + "'," +
                mp.getWeight() + ",'" +  mp.getPID() +  "')";

        try (Statement myStmt = ConnectionFactory.getConnectionToDerby().createStatement()){
            myStmt.execute(insertString);
        }
        catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }

    }

    public void select(){

        String selectionString = "select * from " + tableName;

        try (Statement myStmt = ConnectionFactory.getConnectionToDerby().createStatement();
             ResultSet results = myStmt.executeQuery(selectionString)){

            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++){
                System.out.format("%-40s", rsmd.getColumnLabel(i));
            }

            System.out.println("\n----------------------------------------" +
                    "----------------------------------------" +
                    "----------------------------------------" +
                    "----------------------------------------" +
                    "----------------------------------------");

            while(results.next()){
                String shipper = results.getString(1);
                String origin = results.getString(2);
                String address = results.getString(3);
                Double weight = results.getDouble(4);
                String pid = results.getString(5);

                System.out.format("%-40s%-40s%-40s%-40.2f%-40s%n", shipper, origin, address, weight, pid);
            }

        }
        catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }

    }

}
