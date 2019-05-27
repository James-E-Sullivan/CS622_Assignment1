package custom_exceptions;

public class ParcelSearchException extends Exception {

    // constructor accepts error message strings
    public ParcelSearchException(String errorMessage){

        // call constructor of Exception super class
        super(errorMessage);
    }
}
