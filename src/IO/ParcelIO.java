package IO;

import parcels.Parcel;
import java.io.*;
import java.util.LinkedHashMap;

public class ParcelIO {

    final private static String PARCEL_FILE = "resources/Parcel_Output.dat";

    /**
     * Write Parcel objects from a LinkedHashMap collection
     * into a file that can be saved for later.
     * @param parcelMap: LinkedHashMap with PID,Parcel pairs
     */
    public synchronized static void writeParcel(LinkedHashMap<String, Parcel> parcelMap){

        try {
            ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream(PARCEL_FILE));

            for (Parcel p : parcelMap.values()){
                outfile.writeObject(p);
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("FileNotFoundException");
            ex.printStackTrace();
        }
        catch(IOException ex){
            System.out.println("IOException");
            ex.printStackTrace();
        }

    }

    /**
     * Read Parcel objects from a file (PARCEL_FILE)
     * @return inputMap: LinkedHashMap with PID,Parcel pairs
     */
    public synchronized static LinkedHashMap<String, Parcel> readParcel(){
        LinkedHashMap<String, Parcel> inputMap = new LinkedHashMap<>();

        try {
            ObjectInputStream infile = new ObjectInputStream(new FileInputStream(PARCEL_FILE));

            while (true){
                Parcel inParcel = (Parcel) infile.readObject();
                inputMap.put(inParcel.getParcelID(), inParcel);
            }
        }
        catch(EOFException ex){
            System.out.println("EOF reached in Parcel_Output.dat");
        }
        catch(FileNotFoundException ex){
            System.out.println("FileNotFoundException");
            ex.printStackTrace();
        }
        catch(IOException ex){
            System.out.println("IOException");
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex){
            System.out.println("Parcel object not found in file");
            ex.printStackTrace();
        }
        return inputMap;
    }

}
