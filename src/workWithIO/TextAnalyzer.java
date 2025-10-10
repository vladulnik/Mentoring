package workWithIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class TextAnalyzer {

    public static void analyzeFile(String fileName) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        String longestWord = "";
        int totalWords = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.replaceAll("[^\\p{L}\\p{N}]", "");

                    if (word.length() > 0) {
                        totalWords++;
                        wordFrequency.merge(word.toLowerCase(), 1, Integer::sum);

                        if (word.length() > longestWord.length())
                            longestWord = word;
                    }
                }
            }
            System.out.println("Total words: " + totalWords);
            System.out.println("Longest word: " + longestWord);
            System.out.println("Word frequency: ");
            wordFrequency.forEach((word, count) -> System.out.println(word + ": " + count));
        } catch (IOException e) {
            System.err.println("Error while analyzing file: " + e.getMessage());
        }
    }

    public static void createTestFile(String fileName) throws IOException {
        String content = "Это тестовый файл для анализа текста.\n" +
                "Он содержит несколько строк с разными словами.\n" +
                "Некоторые слова повторяются, некоторые - нет.\n" +
                "Здесь есть и короткие, и длинные слова, например: электрификация.\n" +
                "Анализатор должен корректно обрабатывать такой текст.";

        Files.writeString(Path.of(fileName), content, StandardCharsets.UTF_8);
        System.out.println("Тестовый файл создан: " + fileName);
    }
}
