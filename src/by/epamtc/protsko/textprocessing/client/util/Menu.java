package by.epamtc.protsko.textprocessing.client.util;

public class Menu {

    public static void showMenu() {
        System.out.println("----- Это программа для работы с текстовым файлом -----\n");
        System.out.println("Выберите действие, которое необходимо выполнить с текстовым файлом:");
        System.out.println("1 - Поиск предложений в тексте, в которых есть одинаковые слова.");
        System.out.println("2 - Поиск и печать (без повторений) во всех вопросительных предложениях текста слов заданной длины.");
        System.out.println("3 - Сортировка предложений текста по количеству слов в них.");
        System.out.println("4 - Выход из приложения\n");
    }
}
