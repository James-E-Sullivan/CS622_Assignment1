package output;

import java.io.*;

public class SearchOutput {

    final static String OUTPUT_FILE = "resources/Search_Result_Output";

    public static void writeSearchResults(String results) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(OUTPUT_FILE));
        out.println(results);
        out.close();
    }

    public static void main(String[] args) throws IOException {
        writeSearchResults("Test1");
    }

}
