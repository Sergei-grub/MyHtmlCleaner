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

        // Ожидание нажатия клавиши перед закрытием
        System.out.println("Нажмите Enter для выхода...");
        new Scanner(System.in).nextLine();
    }
}