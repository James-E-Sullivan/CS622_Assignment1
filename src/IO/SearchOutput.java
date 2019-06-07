package IO;

import java.io.*;
import java.util.LinkedList;

// class with methods for handling text file writing
public class SearchOutput {

    final static String OUTPUT_FILE = "resources/Search_Result_Output";

    /**
     * Appends String of search results to OUTPUT_FILE
     * @param results: String of user search results
     */
    public static void writeSearchResults(String results) {

        try{
            PrintWriter out = new PrintWriter(new FileWriter(OUTPUT_FILE, true));   // append to file
            out.println("\n" + results);
            out.close();
        }

        catch (IOException ex){
            System.err.println("Caught IOException while writing search results: " +
                    ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Overwrites OUTPUT_FILE with String of search results.
     * @param results: String of user search results.
     */
    public static void overwriteSearchResults(String results){

        try{
            PrintWriter out = new PrintWriter(new FileWriter(OUTPUT_FILE));
            out.println(results);
            out.close();
        }

        catch (IOException ex){
            System.err.println("Caught IOException while overwriting search results: " +
                    ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Outputs multiple search results to IO txt file
     * @param outputList: List containing multiple display results
     */
    public static void writeSearchResultList(LinkedList<String> outputList){

        try{
            PrintWriter out = new PrintWriter(new FileWriter(OUTPUT_FILE, true));
            for(String s : outputList){
                out.println("\n" + s);
            }
            out.close();
        }

        catch (IOException ex){
            System.err.println("Caught IOException while writing IO search list: " +
                    ex.getMessage());
            ex.printStackTrace();
        }
    }


}
