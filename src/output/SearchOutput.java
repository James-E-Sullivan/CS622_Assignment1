package output;

import java.io.*;

public class SearchOutput {

    final static String OUTPUT_FILE = "resources/Search_Result_Output";

    /**
     * Appends String of search results to OUTPUT_FILE
     * @param results: String of user search results
     * @throws IOException: Throws IOException to caller
     */
    public void writeSearchResults(String results) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(OUTPUT_FILE, true));   // append to file
        out.println("\n" + results);
        out.close();
    }

    /**
     * Overwrites OUTPUT_FILE with String of search results.
     * @param results: String of user search results.
     * @throws IOException: Throws IOException to caller
     */
    public void overwriteSearchResults(String results) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(OUTPUT_FILE));
        out.println(results);
        out.close();
    }


}
