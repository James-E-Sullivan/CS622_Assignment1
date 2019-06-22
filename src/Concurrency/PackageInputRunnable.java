package Concurrency;

import IO.PackageIO;
import IO.Package_CSV_Input;
import mail_packages.MailPackage;

import java.util.ArrayList;

public class PackageInputRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("\nStarting Package CSV Thread\n");

        Package_CSV_Input packageInput = new Package_CSV_Input();
        packageInput.read_CSV_File();
        ArrayList<MailPackage> packageList = packageInput.getPackageList();
        PackageIO.writePackage(packageList);

        System.out.println("\nEnding Package CSV Thread\n");
    }
}
