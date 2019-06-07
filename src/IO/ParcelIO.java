package IO;

import parcels.Parcel;

import java.io.*;
import java.util.HashMap;

public class ParcelIO {

    final static String OBJECT_FILE = "resources/Object_Output.dat";

    public void writeParcel(HashMap<String, Parcel> parcelMap){

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

    public HashMap<String, Parcel> readParcel(){
        HashMap<String, Parcel> inputMap = new HashMap<>();

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

        // test
        for (Parcel p : inputMap.values()){
            System.out.println(p.display());
        }

        return inputMap;
    }


}
