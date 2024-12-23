package View;

import Controller.NewsController;
import Controller.*;
import uniUtil.*;
import Enum.*;
import java.util.Scanner;
import Model.*;
import data.Database;

public class ViewDean {
    private static Dean myDean = null;
    private static Language currentLanguage = Language.ENG;

    public static void chooseLanguage() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Select your language / Выберите язык / Тілді таңдаңыз:");
        System.out.println("1. English");
        System.out.println("2. Русский");
        System.out.println("3. Қазақ тілі");
        int choice = scan.nextInt();
        if (choice == 1) {
            currentLanguage = Language.ENG;
        } else if (choice == 2) {
            currentLanguage = Language.RU;
        } else if (choice == 3) {
            currentLanguage = Language.KZ;
        }
    }

    public static void menu(Dean dean) {
        myDean = dean; // Сохраняем ссылку на декана
        Scanner scan = new Scanner(System.in);

        while (true) {
            // Печать меню в зависимости от выбранного языка
            if (currentLanguage == Language.ENG) {
                System.out.println("Welcome to WSP!\nSelect the option:");
                System.out.println("1. News");
                System.out.println("2. View complaints");
                System.out.println("3. View requests");
                System.out.println("4. View reports"); // Добавили опцию для просмотра репортов
                System.out.println("5. Exit to Main Menu");
            } else if (currentLanguage == Language.RU) {
                System.out.println("Добро пожаловать в WSP\nВыберите опцию:");
                System.out.println("1. Новости");
                System.out.println("2. Просмотр жалоб");
                System.out.println("3. Просмотр запросов");
                System.out.println("4. Просмотр репортов"); // Добавили опцию для просмотра репортов
                System.out.println("5. Выход в главное меню");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("WSP-ға қош келдіңіз\nОпцияны таңдаңыз:");
                System.out.println("1. Жаңалықтар");
                System.out.println("2. Шағымдарды қарастыру");
                System.out.println("3. Сұраныстарды қарастыру");
                System.out.println("4. Репорттарды қарау"); // Добавили опцию для просмотра репортов
                System.out.println("5. Негізгі мәзірге қайту");
            }

            // Ввод опции пользователем
            int option = scan.nextInt();

            // Обработка опций
            if (option == 1) {
                NewsController.viewNews(currentLanguage, myDean, UserType.DEAN);
            } else if (option == 2) {
                // Действие для просмотра жалоб
            } else if (option == 3) {
                viewRequests();
            } else if (option == 4) {
                viewReports(); // Вызов метода для просмотра репортов
            } else if (option == 5) {
                myDean = null;
                BaseView.welcome(); // Возвращаем в главное меню
                break;
            } else {
                System.out.println(currentLanguage == Language.ENG ? "Invalid option. Try again." :
                        currentLanguage == Language.RU ? "Неверная опция. Попробуйте снова." :
                                "Қате нұсқа. Қайтадан көріңіз.");
            }
        }
    }

    private static void viewRequests() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            // Получение списка запросов
            var requests = Database.EmployeeRequestDB;

            // Проверка наличия запросов
            if (requests.isEmpty()) {
                System.out.println(currentLanguage == Language.ENG ? "No requests available." :
                        currentLanguage == Language.RU ? "Запросов нет." :
                                "Сұраныстар жоқ.");
                break; // Выход из метода
            }

            // Вывод списка запросов
            System.out.println(currentLanguage == Language.ENG ? "List of Requests:" :
                    currentLanguage == Language.RU ? "Список запросов:" :
                            "Сұраныстар тізімі:");
            int index = 1;
            for (Request request : requests) {
                System.out.println(index++ + ". " + request.toString());
            }

            // Печать опций
            System.out.println(currentLanguage == Language.ENG ? "Choose a request to sign (enter number) or 0 to return to menu:" :
                    currentLanguage == Language.RU ? "Выберите запрос для подписания (введите номер) или 0 для возврата в меню:" :
                            "Сұранысты қол қою үшін таңдаңыз (нөмірді енгізіңіз) немесе мәзірге оралу үшін 0 енгізіңіз:");
            int choice = scan.nextInt();

            if (choice == 0) {
                break; // Выход в главное меню
            } else if (choice > 0 && choice <= requests.size()) {
                Request selectedRequest = requests.get(choice - 1);
                RequestController.signRequest(selectedRequest);

                System.out.println(currentLanguage == Language.ENG ? "Request signed successfully!" :
                        currentLanguage == Language.RU ? "Запрос успешно подписан!" :
                                "Сұраныс сәтті қол қойылды!");
            } else {
                System.out.println(currentLanguage == Language.ENG ? "Invalid choice. Try again." :
                        currentLanguage == Language.RU ? "Неверный выбор. Попробуйте снова." :
                                "Қате таңдау. Қайтадан көріңіз.");
            }
        }
    }

    // Новый метод для просмотра репортов
    private static void viewReports() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            // Получение списка репортов
            var reports = Database.ReportDB; // Здесь обращаемся к базе данных репортов

            // Проверка наличия репортов
            if (reports.isEmpty()) {
                System.out.println(currentLanguage == Language.ENG ? "No reports available." :
                        currentLanguage == Language.RU ? "Репортов нет." :
                                "Репорттар жоқ.");
                break; // Выход из метода
            }

            // Вывод списка репортов
            System.out.println(currentLanguage == Language.ENG ? "List of Reports:" :
                    currentLanguage == Language.RU ? "Список репортов:" :
                            "Репорттар тізімі:");
            int index = 1;
            for (Report report : reports) {
                System.out.println(index++ + ". " + report.toString());
            }

            // Печать опций
            System.out.println(currentLanguage == Language.ENG ? "Choose a report to view (enter number), 0 to return to menu:" :
                    currentLanguage == Language.RU ? "Выберите репорт для просмотра (введите номер), 0 для возврата в меню:" :
                            "Репортты көру үшін нөмірді енгізіңіз, мәзірге оралу үшін 0 енгізіңіз:");
            int choice = scan.nextInt();

            if (choice == 0) {
                break; // Выход в главное меню
            } else if (choice > 0 && choice <= reports.size()) {
                Report selectedReport = reports.get(choice - 1);
                System.out.println(currentLanguage == Language.ENG ? "Report details: " + selectedReport.toString() :
                        currentLanguage == Language.RU ? "Детали репорта: " + selectedReport.toString() :
                                "Репорт мәліметтері: " + selectedReport.toString());
            } else {
                System.out.println(currentLanguage == Language.ENG ? "Invalid choice. Try again." :
                        currentLanguage == Language.RU ? "Неверный выбор. Попробуйте снова." :
                                "Қате таңдау. Қайтадан көріңіз.");
            }
        }
    }
}
