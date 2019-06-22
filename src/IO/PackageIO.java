package IO;

import mail_packages.MailPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class PackageIO {

    final private static String PACKAGE_FILE = "resources/Package_Output.dat";

    public static void writePackage(ArrayList<MailPackage> packageList){
        try {
            ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream(PACKAGE_FILE));

            for (MailPackage p : packageList){
                outfile.writeObject(p);
            }
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch(IOException ex){
            System.out.println("IOException");
            ex.printStackTrace();
        }
    }

    public static ArrayList<MailPackage> readPackage(){
        ArrayList<MailPackage> inputList = new ArrayList<>();

        try {
            ObjectInputStream infile = new ObjectInputStream(new FileInputStream(PACKAGE_FILE));

            while (true){
                MailPackage inPackage = (MailPackage) infile.readObject();
                inputList.add(inPackage);
            }
        }
        catch (EOFException ex){
            System.out.println("EOF reached in Package_Output.dat");
        }
        catch (FileNotFoundException ex){
            System.out.println("FileNotFoundException");
            ex.printStackTrace();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex){
            System.out.println("Class not found");
            ex.printStackTrace();
        }

        return inputList;
    }

}
