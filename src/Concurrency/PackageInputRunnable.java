package Concurrency;

import IO.PackageIO;
import IO.Package_CSV_Input;
import mail_packages.MailPackage;

import java.util.ArrayList;

public class PackageInputRunnable implements Runnable{

    @Override
    public void run() {
        Package_CSV_Input packageInput = new Package_CSV_Input();
        packageInput.read_CSV_File();
        ArrayList<MailPackage> packageList = packageInput.getPackageList();
        PackageIO.writePackage(packageList);
    }
}
