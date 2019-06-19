package database;

import parcels.Parcel;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//https://db.apache.org/derby/integrate/plugin_help/derby_app.html

public class ParcelTableSQL {

    // default constructor
    public ParcelTableSQL(String name){tableName = name;}

    private static Statement stmt;
    //private static String tableName = "allParcels";
    private static  String tableName;


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

    public void initFullParcelTable(){
        // create table
        try(Statement myStmt = ConnectionFactory.getConnectionToDerby().createStatement()){
            myStmt.execute("drop table " + tableName);
            myStmt.execute("create table " + tableName + "(PID varchar(10)," + " address varchar(100)," + " type varchar(100)," + " property_value integer," + " land_area integer) ");
            System.out.println("Created Parcel Table");
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

    public static void insertParcelRecord(String PID, String address, String type,
                                          Integer pv, Integer landArea, Integer livingArea,
                                          Integer bedrooms){
        try (Statement myStmt = ConnectionFactory.getConnectionToDerby().createStatement()){
            myStmt.execute("insert into " + tableName + " values (" + "'" + PID + "'" + ",'"
                    + address + "','" + type + "'," + pv + "," + landArea + "," + livingArea
                    + "," + bedrooms +  ")");
        }
        catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    }

    public void insertParcelObject(Parcel p){
        try (Statement myStmt = ConnectionFactory.getConnectionToDerby().createStatement()){
            myStmt.execute("insert into " + tableName + " values (" + "'" + p.getParcelID() + "'" + ",'"
                    + p.getAddress() + "','" + p.getType() + "'," + p.getPropertyValue() + "," +
                    p.getLandArea() + ")");
        }
        catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    }

    public static void selectAll(){
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


    public void selectParcelData(){
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
                Integer propertyValue = results.getInt(4);
                Integer landArea = results.getInt(5);

                /*
                Integer livingArea = results.getInt(6);
                Integer bedrooms = results.getInt(7);
                System.out.println(PID + "\t\t" + address + "\t\t" + type + "\t\t" + propertyValue +
                        "\t\t" + landArea + "\t\t" + livingArea + "\t\t" + bedrooms);

                 */

                System.out.println(PID + "\t\t" + address + "\t\t" + type + "\t\t" + propertyValue +
                        "\t\t" + landArea);
            }

        }
        catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }
    }

    public void selectByPropertyValue(Integer value){

        // query String to select all from table
        // ordered by descending property values greater than value parameter
        String query1 = "select * from " + tableName +
                " where property_value > " + value +
                " order by property_value desc ";

        try(Statement myStmt = ConnectionFactory.getConnectionToDerby().createStatement();
            ResultSet results = myStmt.executeQuery(query1);
        ){
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
                String PID = results.getString(1);
                String address = results.getString(2);
                String type = results.getString(3);
                Integer property_value = results.getInt(4);
                Integer land_area = results.getInt(5);

                System.out.format("%-40s%-40s%-40s%-40d%-40d%n", PID, address, type, property_value, land_area);
            }

        }
        catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
    }


}
