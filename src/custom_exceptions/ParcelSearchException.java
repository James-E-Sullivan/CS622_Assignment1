package custom_exceptions;

// custom Exception for errors during ParcelSearch prompting
public class ParcelSearchException extends Exception {

    // constructor accepts error message strings
    public ParcelSearchException(String errorMessage){

        // call constructor of Exception super class
        super(errorMessage);
    }
}
