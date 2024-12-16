package fnpr.example;

import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class HtmlCleaner {
    public static void main(String[] args) {
        // Путь к файлам
        String inputFilePath = new File("input.txt").getAbsolutePath();
        String outputFilePath = new File("output.txt").getAbsolutePath();


        try {
            // Чтение текста из input.txt с кодировкой UTF-8
            String textWithTags = Files.readString(Paths.get(inputFilePath));

            // Удаление HTML-тегов с помощью Jsoup
            String cleanedText = Jsoup.parse(textWithTags).text();

            // Запись очищенного текста в output.txt с кодировкой UTF-8
            Files.writeString(Paths.get(outputFilePath), cleanedText);
            System.out.println("Теги успешно удалены. Результат сохранен в output.txt.");
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        }

        // Ожидание нажатия клавиши перед закрытием
        System.out.println("Нажмите Enter для выхода...");
        new Scanner(System.in).nextLine();
    }
}