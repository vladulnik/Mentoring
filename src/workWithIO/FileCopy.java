package workWithIO;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileCopy {
    public static void copyFile(String sourceFile, String destFile) {
        try(BufferedReader reader = new BufferedReader(new FileReader(sourceFile, StandardCharsets.UTF_8));
            BufferedWriter writer = new BufferedWriter(new FileWriter(destFile, StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error while copying file: " + e.getMessage());
        }
    }
}
