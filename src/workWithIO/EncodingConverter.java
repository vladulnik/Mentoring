package workWithIO;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class EncodingConverter {
    public static void convertEncoding(String inputFile, String outputFile, String fromEncoding, String toEncoding) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), fromEncoding));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), toEncoding))) {
            String line;

            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error while converting: " + e.getMessage());
        }
    }
}
