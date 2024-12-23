package View;

import Controller.*;
import data.Database;
import uniUtil.*;
import Enum.*;
import Model.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class ViewLibrarian {
    private static Language currentLanguage = Language.ENG;
    private static Librarian myLibrarian = null;

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

    public static void menu(Librarian librarian) {
        Scanner scan = new Scanner(System.in);
        myLibrarian = librarian;

        // Печать меню в зависимости от выбранного языка
        if (currentLanguage == Language.ENG) {
            System.out.println("Welcome to WSP!\n Select the option:");
            System.out.println("1. News");
            System.out.println("2. List of taken books");
            System.out.println("3. List of free books");
            System.out.println("4. Send request");
            System.out.println("5. View your requests");
            System.out.println("6. Exit to Main Menu");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Добро пожаловать в WSP\n Выберите опцию:");
            System.out.println("1. Новости");
            System.out.println("2. Список взятых книг");
            System.out.println("3. Список свободных книг");
            System.out.println("4. Отправка запроса");
            System.out.println("5. Просмотр ваших запросов");
            System.out.println("6. Выход в главное меню");
        } else if (currentLanguage == Language.KZ) {
            System.out.println("WSP-ға қош келдіңіз\n Опцияны таңдаңыз:");
            System.out.println("1. Жаңалықтар");
            System.out.println("2. Алынған кітаптар тізімі");
            System.out.println("3. Бос кітаптардың тізімі");
            System.out.println("4. Сұраныс жіберу");
            System.out.println("5. Сіздің сұраныстарыңызды қарау");
            System.out.println("6. Негізгі мәзірге қайту");
        }

        // Ввод опции пользователем
        int option = scan.nextInt();

        // Обработка опций
        if (option == 1) {
            NewsController.viewNews(currentLanguage, myLibrarian, UserType.LIBRARIAN);
        } else if (option == 2) {
            listTakenBooks();
        } else if (option == 3) {
            listAvailableBooks();
        } else if (option == 4) {
            handleSendRequest(); // Обработка запроса
        } else if (option == 5) {
            viewRequests(); // Просмотр запросов
        } else if (option == 6) {
            librarian = null;
            BaseView.welcome(); // Возвращаем в главное меню
        } else {
            printInvalidOptionMessage();
        }
    }

    private static void listTakenBooks() {
        if (currentLanguage == Language.ENG) {
            System.out.println("Taken Books:");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Список взятых книг:");
        } else if (currentLanguage == Language.KZ) {
            System.out.println("Алынған кітаптар тізімі:");
        }
        for (Map.Entry<Student, Vector<Book>> entry : Database.ListOFstudents.entrySet()) {
            Student student = entry.getKey();
            Vector<Book> books = entry.getValue();
            if (currentLanguage == Language.ENG) {
                System.out.println("Student: " + student.getUsername());
            } else if (currentLanguage == Language.RU) {
                System.out.println("Студент: " + student.getUsername());
            } else if (currentLanguage == Language.KZ) {
                System.out.println("Студент: " + student.getUsername());
            }
            for (Book book : books) {
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    private static void listAvailableBooks() {
        if (currentLanguage == Language.ENG) {
            System.out.println("Available Books:");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Список свободных книг:");
        } else if (currentLanguage == Language.KZ) {
            System.out.println("Бос кітаптардың тізімі:");
        }
        for (Map.Entry<Book, Integer> entry : Database.CountOfbooks.entrySet()) {
            Book book = entry.getKey();
            int count = entry.getValue();
            if (count > 0) {
                if (currentLanguage == Language.ENG) {
                    System.out.println("- " + book.getTitle() + " by " + book.getAuthor() + " (" + count + " copies)");
                } else if (currentLanguage == Language.RU) {
                    System.out.println("- " + book.getTitle() + " автор: " + book.getAuthor() + " (" + count + " экземпляров)");
                } else if (currentLanguage == Language.KZ) {
                    System.out.println("- " + book.getTitle() + " авторы: " + book.getAuthor() + " (" + count + " дана)");
                }
            }
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
        myLibrarian.addRequest(newRequest);
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
        menu(myLibrarian);
    }

    private static void viewRequests() {
        // Получаем список запросов для библиотекаря
        if (myLibrarian != null && myLibrarian.getRequests() != null && !myLibrarian.getRequests().isEmpty()) {
            if (currentLanguage == Language.ENG) {
                System.out.println("Your Requests:");
            } else if (currentLanguage == Language.RU) {
                System.out.println("Ваши запросы:");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("Сіздің сұраныстарыңыз:");
            }

            // Выводим запросы
            for (Request request : myLibrarian.getRequests()) {
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
            menu(myLibrarian); // Вернуться в меню
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
}
