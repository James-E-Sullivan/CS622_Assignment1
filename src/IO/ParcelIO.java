package IO;

import parcels.Parcel;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ParcelIO {

    final private static String OBJECT_FILE = "resources/Object_Output.dat";

    /**
     * Write Parcel objects from a LinkedHashMap collection
     * into a file that can be saved for later.
     * @param parcelMap: LinkedHashMap with PID,Parcel pairs
     */
    public static void writeParcel(LinkedHashMap<String, Parcel> parcelMap){

        try {
            ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream(OBJECT_FILE));

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
     * Read Parcel objects from a file (OBJECT_FILE)
     * @return inputMap: LinkedHashMap with PID,Parcel pairs
     */
    public static LinkedHashMap<String, Parcel> readParcel(){
        LinkedHashMap<String, Parcel> inputMap = new LinkedHashMap<>();

        try {
            ObjectInputStream infile = new ObjectInputStream(new FileInputStream(OBJECT_FILE));

            while (true){
                Parcel inParcel = (Parcel) infile.readObject();
                inputMap.put(inParcel.getParcelID(), inParcel);
            }
        }
        catch(EOFException ex){
            System.out.println("EOF reached in Object_Output.dat");
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
