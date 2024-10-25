package fnpr.example;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HtmlCleaner {
    public static void main(String[] args) {
        // Путь к файлам
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";


        try {
            // Чтение текста из файла input.txt
            String textWithTags = new String(Files.readAllBytes(Paths.get(inputFilePath)));

            // Удаление HTML-тегов с помощью Jsoup
            String cleanedText = Jsoup.parse(textWithTags).text();

            // Запись очищенного текста в файл output.txt
            Files.write(Paths.get(outputFilePath), cleanedText.getBytes());
            System.out.println("Теги успешно удалены. Результат сохранен в output.txt.");
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }
}


