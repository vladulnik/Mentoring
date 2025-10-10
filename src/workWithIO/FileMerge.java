package workWithIO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

public class FileMerge {
    public static void mergeFiles(List<String> fileNames, String outputFile, String separator) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, StandardCharsets.UTF_8))) {
            boolean isFirst = true;

            for(String fileName : fileNames) {
                if(!isFirst) {
                    writer.write(separator);
                    writer.newLine();
                }

                try (BufferedReader reader = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine();
                    }
                }

                isFirst = false;
            }
        } catch (IOException e) {
            System.err.println("Error while merging: " + e.getMessage());
        }
    }
}
