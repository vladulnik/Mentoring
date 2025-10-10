package workWithIO;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SimpleTextEditor {
    public static void appendText(String fileName, String text) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, StandardCharsets.UTF_8, true))) {
            writer.write(text);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error while writing the file: " + e.getMessage());
        }
    }

    public static void showContent(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) {
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error while reading the file: " + e.getMessage());
        }
    }
}
