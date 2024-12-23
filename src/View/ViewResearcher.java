package View;

import Research.*;
import Model.*;
import java.util.Scanner;

public class ViewResearcher {
    private static String language = "EN"; // Default language: English

    public static void setLanguage(String lang) {
        language = lang;
    }

    private static String translate(String en, String ru, String kz) {
        return switch (language) {
            case "RU" -> ru;
            case "KZ" -> kz;
            default -> en;
        };
    }

    public static void viewResearcherMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(translate(
                    "\nResearcher Menu:",
                    "\nМеню Исследователя:",
                    "\nЗерттеушінің мәзірі:"
            ));

            System.out.println(translate(
                    "1. Find Researcher",
                    "1. Найти исследователя",
                    "1. Зерттеушіні табу"
            ));

            System.out.println(translate(
                    "2. Find Research Project",
                    "2. Найти исследовательский проект",
                    "2. Зерттеу жобасын табу"
            ));

            System.out.println(translate(
                    "3. Back to Main Menu",
                    "3. Вернуться в главное меню",
                    "3. Негізгі мәзірге оралу"
            ));

            System.out.print(translate(
                    "Choose an option: ",
                    "Выберите опцию: ",
                    "Опцияны таңдаңыз: "
            ));

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1 -> findResearcher(scanner);
                case 2 -> findResearchProject(scanner);
                case 3 -> {
                    return;
                }
                default -> System.out.println(translate(
                        "Invalid choice! Please try again.",
                        "Неверный выбор! Пожалуйста, попробуйте еще раз.",
                        "Қате таңдау! Қайтадан көріңіз."
                ));
            }
        }
    }

    private static void findResearcher(Scanner scanner) {
        System.out.print(translate(
                "Enter researcher name: ",
                "Введите имя исследователя: ",
                "Зерттеушінің атын енгізіңіз: "
        ));
        String name = scanner.nextLine();

        Researcher researcher = Database.findResearcherByName(name);
        if (researcher != null) {
            System.out.println(translate(
                    "Researcher found: " + researcher,
                    "Исследователь найден: " + researcher,
                    "Зерттеуші табылды: " + researcher
            ));
        } else {
            System.out.println(translate(
                    "Researcher not found.",
                    "Исследователь не найден.",
                    "Зерттеуші табылмады."
            ));
        }
    }

    private static void findResearchProject(Scanner scanner) {
        System.out.print(translate(
                "Enter project title: ",
                "Введите название проекта: ",
                "Жобаның атауын енгізіңіз: "
        ));
        String title = scanner.nextLine();

        ResearchProject project = Database.findProjectByTitle(title);
        if (project != null) {
            System.out.println(translate(
                    "Project found: " + project,
                    "Проект найден: " + project,
                    "Жоба табылды: " + project
            ));
        } else {
            System.out.println(translate(
                    "Project not found.",
                    "Проект не найден.",
                    "Жоба табылмады."
            ));
        }
    }
}