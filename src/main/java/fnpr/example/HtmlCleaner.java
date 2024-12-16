package fnpr.example;

import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class HtmlCleaner {
    public static void main(String[] args) {
        // Получаем текущую рабочую директорию
        String currentDir = System.getProperty("user.dir");

        // Определяем относительные пути к файлам
        String inputFilePath = currentDir + File.separator + "input.txt";
        String outputFilePath = currentDir + File.separator + "output.txt";

        // Создаем файлы, если они не существуют
        createFileIfNotExists(inputFilePath);
        createFileIfNotExists(outputFilePath);

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

    private static void createFileIfNotExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("Файл создан: " + filePath);
                } else {
                    System.out.println("Не удалось создать файл: " + filePath);
                }
            } catch (IOException e) {
                System.out.println("Ошибка при создании файла: " + e.getMessage());
            }
        } else {
            System.out.println("Файл уже существует: " + filePath);
        }
    }
}