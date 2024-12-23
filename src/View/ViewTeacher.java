package View;

import Controller.NewsController;
import Controller.RequestController; // Добавим контроллер для обработки запросов
import uniUtil.*;
import Enum.*;
import Model.*;
import java.util.Scanner;
import java.time.LocalDateTime;

public class ViewTeacher {
    private static Language currentLanguage = Language.ENG; // по умолчанию
    private static Teacher myTeacher = null;

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

    public static void menu(Teacher teacher) {
        Scanner scan = new Scanner(System.in);
        myTeacher = teacher;
        // Печать меню в зависимости от выбранного языка
        if (currentLanguage == Language.ENG) {
            System.out.println("Welcome to WSP!\n Select the option:");
            System.out.println("1. News");
            System.out.println("2. Research Projects");
            System.out.println("3. Send Complaints");
            System.out.println("4. List of students");
            System.out.println("5. Chat");
            System.out.println("6. Send request");
            System.out.println("7. View your requests");
            System.out.println("8. Exit to Main Menu");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Добро пожаловать в WSP\n Выберите опцию:");
            System.out.println("1. Новости");
            System.out.println("2. Научные статьи");
            System.out.println("3. Отправка Жалобы");
            System.out.println("4. Список студентов");
            System.out.println("5. Чат");
            System.out.println("6. Отправка запроса");
            System.out.println("7. Просмотр ваших запросов");
            System.out.println("8. Выход в главное меню");
        } else if (currentLanguage == Language.KZ) {
            System.out.println("WSP-ға қош келдіңіз\n Опцияны таңдаңыз:");
            System.out.println("1. Жаңалықтар");
            System.out.println("2. Ғылыми мақалалар");
            System.out.println("3. Шағымдану");
            System.out.println("4. Студенттер тізімі");
            System.out.println("5. Чат");
            System.out.println("6. Сұраныс жіберу");
            System.out.println("7. Сіздің сұраныстарыңызды қарау");
            System.out.println("8. Негізгі мәзірге қайту");
        }

        // Ввод опции пользователем
        int option = scan.nextInt();

        // Обработка опций
        if (option == 1) {
            NewsController.viewNews(currentLanguage, myTeacher, UserType.TEACHER);
        } else if (option == 2) {
            // Действие для научных статей
        } else if (option == 3) {
            handleSendReport();
        } else if (option == 4) {
            // Действие для списка студентов
        } else if (option == 5) {
            // Действие для чата
        } else if (option == 6) {
            handleSendRequest();
        } else if (option == 7) {
            viewRequests();
        } else if (option == 8) {
            myTeacher = null;
            BaseView.welcome(); // Возвращаем в главное меню
        }
    }

    private static void handleSendRequest() {
        Scanner scan = new Scanner(System.in);

        // Выводим текст в зависимости от языка
        if (currentLanguage == Language.ENG) {
            System.out.println("Please enter the topic of the request:");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Введите тему запроса:");
        } else if (currentLanguage == Language.KZ) {
            System.out.println("Сұраныстың тақырыбын енгізіңіз:");
        }

        // Ввод темы запроса
        String topic = scan.nextLine();

        // Выводим текст в зависимости от языка
        if (currentLanguage == Language.ENG) {
            System.out.println("Please enter the details of the request:");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Введите детали запроса:");
        } else if (currentLanguage == Language.KZ) {
            System.out.println("Сұраныстың мәліметтерін енгізіңіз:");
        }

        // Ввод деталей запроса
        String details = scan.nextLine();

        // Создаём объект Request с нужными параметрами
        Request newRequest = new Request(topic, LocalDateTime.now(), details);
        myTeacher.addRequest(newRequest);
        // Отправляем запрос через RequestController
        RequestController.acceptRequest(newRequest);

        // Выводим сообщение об успешной отправке запроса
        if (currentLanguage == Language.ENG) {
            System.out.println("Your request has been sent: " + details);
        } else if (currentLanguage == Language.RU) {
            System.out.println("Ваш запрос был отправлен: " + details);
        } else if (currentLanguage == Language.KZ) {
            System.out.println("Сұранысыңыз жіберілді: " + details);
        }

        // Возврат в меню
        System.out.println("\nReturning to the main menu...");
        menu(myTeacher);
    }

    private static void viewRequests() {
        // Получаем список запросов для учителя
        if (myTeacher != null && myTeacher.getRequests() != null && !myTeacher.getRequests().isEmpty()) {
            if (currentLanguage == Language.ENG) {
                System.out.println("Your Requests:");
            } else if (currentLanguage == Language.RU) {
                System.out.println("Ваши запросы:");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("Сіздің сұраныстарыңыз:");
            }

            // Выводим запросы
            for (Request request : myTeacher.getRequests()) {
                System.out.println("Topic: " + request.getTopic());
                if (request.getIsSigned()) {
                    System.out.println("Status: Signed");
                } else {
                    System.out.println("Status: Not Signed");
                }
                System.out.println("----------------------------------");
            }
        } else {
            // Если запросов нет
            if (currentLanguage == Language.ENG) {
                System.out.println("You have no requests.");
            } else if (currentLanguage == Language.RU) {
                System.out.println("У вас нет запросов.");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("Сіздің сұраныстарыңыз жоқ.");
            }
        }

        // Печатаем опции для пользователя
        System.out.println("\nSelect an option:");
        if (currentLanguage == Language.ENG) {
            System.out.println("1. Send a new request");
            System.out.println("2. Return to the main menu");
        } else if (currentLanguage == Language.RU) {
            System.out.println("1. Отправить новый запрос");
            System.out.println("2. Вернуться в главное меню");
        } else if (currentLanguage == Language.KZ) {
            System.out.println("1. Жаңа сұраныс жіберу");
            System.out.println("2. Негізгі мәзірге қайту");
        }

        // Ввод опции
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();

        // Обработка выбора
        if (option == 1) {
            handleSendRequest(); // Отправить новый запрос
        } else if (option == 2) {
            menu(myTeacher); // Вернуться в меню
        } else {
            printInvalidOptionMessage();
        }
    }

    private static void printInvalidOptionMessage() {
        if (currentLanguage == Language.ENG) {
            System.out.println("Invalid option. Please try again.");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Неверная опция. Пожалуйста, попробуйте снова.");
        } else if (currentLanguage == Language.KZ) {
            System.out.println("Қате опция. Қайталап көріңіз.");
        }
    }

    private static void handleSendReport() {
        Scanner scan = new Scanner(System.in);

        // Вывод текста в зависимости от языка
        if (currentLanguage == Language.ENG) {
            System.out.println("Please enter the topic of the report:");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Введите тему репорта:");
        } else if (currentLanguage == Language.KZ) {
            System.out.println("Репорт тақырыбын енгізіңіз:");
        }

        // Ввод темы репорта
        String topic = scan.nextLine();

        if (currentLanguage == Language.ENG) {
            System.out.println("Please enter the details of the report:");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Введите детали репорта:");
        } else if (currentLanguage == Language.KZ) {
            System.out.println("Репорт мәліметтерін енгізіңіз:");
        }

        // Ввод деталей репорта
        String details = scan.nextLine();

        // Выбор уровня срочности с помощью switch
        Urgencylevel urgencyLevel = null;
        if (currentLanguage == Language.ENG) {
            System.out.println("Select the urgency level (1. Low, 2. Medium, 3. High):");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Выберите уровень срочности (1. Низкий, 2. Средний, 3. Высокий):");
        } else if (currentLanguage == Language.KZ) {
            System.out.println("Срочность деңгейін таңдаңыз (1. Төмен, 2. Орташа, 3. Жоғары):");
        }

        // Ввод уровня срочности
        int urgencyChoice = scan.nextInt();
        switch (urgencyChoice) {
            case 1:
                urgencyLevel = Urgencylevel.LOW;
                break;
            case 2:
                urgencyLevel = Urgencylevel.MEDIUM;
                break;
            case 3:
                urgencyLevel = Urgencylevel.HIGH;
                break;
            default:
                System.out.println("Invalid choice! Setting urgency to LOW.");
                urgencyLevel = Urgencylevel.LOW;
        }

        // Создаем объект Report
        Report newReport = new Report(topic, LocalDateTime.now(), details, urgencyLevel);
        // Сохраняем репорт через ReportController
        RequestController.addReport(newReport);

        // Выводим сообщение об успешной отправке репорта
        if (currentLanguage == Language.ENG) {
            System.out.println("Your report has been sent: " + details);
        } else if (currentLanguage == Language.RU) {
            System.out.println("Ваш репорт был отправлен: " + details);
        } else if (currentLanguage == Language.KZ) {
            System.out.println("Сіздің репортыңыз жіберілді: " + details);
        }

        // Возврат в меню
        System.out.println("\nReturning to the main menu...");
        menu(myTeacher);
    }

}
