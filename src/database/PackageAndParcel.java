package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class PackageAndParcel {


    private static void aggregateSelection(){

        String query = "select property_value, shipper from parcels, packages where parcels.PID = packages.PID";

        try(Statement myStmt = ConnectionFactory.getConnectionToDerby().createStatement();
            ResultSet results = myStmt.executeQuery(query)){
            ResultSetMetaData rsmd = results.getMetaData();

            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++){
                System.out.format("%-40s", rsmd.getColumnLabel(i));
            }

            System.out.println("\n----------------------------------------" +
                    "----------------------------------------");

            while(results.next()){
                String pv = results.getString(1);
                String shipper = results.getString(2);

                System.out.format("%-40s%-40s%n", pv, shipper);
            }
        }
        catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
        }

    }

    public static void main(String[] args) {

        aggregateSelection();

    }

}
