package View;
import Controller.NewsController;
import data.Database;
import uniUtil.*;
import Enum.*;

import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import Model.*;
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
            System.out.println("4. Exit to Main Menu");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Добро пожаловать в WSP\n Выберите опцию:");
            System.out.println("1. Новости");
            System.out.println("2. Список взятых книг");
            System.out.println("3. Список свободных книг");
            System.out.println("4. Выход в главное меню");
        } else if (currentLanguage == Language.KZ) {
            System.out.println("WSP-ға қош келдіңіз\n Опцияны таңдаңыз:");
            System.out.println("1. Жаңалықтар");
            System.out.println("2. Алынған кітаптар тізімі");
            System.out.println("3. Бос кітаптардың тізімі");
            System.out.println("4. Негізгі мәзірге қайту");
        }

        // Ввод опции пользователем
        int option = scan.nextInt();

        // Обработка опций
        if (option == 1) {
            NewsController.viewNews(currentLanguage, myLibrarian, UserType.LIBRARIAN);
        } else if (option == 2) {
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
        } else if (option == 3) {
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
        } else if (option == 4) {
            librarian = null;
            BaseView.welcome(); // Возвращаем в главное меню
        } else {
            if (currentLanguage == Language.ENG) {
                System.out.println("Invalid option. Please try again.");
            } else if (currentLanguage == Language.RU) {
                System.out.println("Неверная опция. Пожалуйста, попробуйте снова.");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("Қате опция. Қайталап көріңіз.");
            }
        }
    }
}
