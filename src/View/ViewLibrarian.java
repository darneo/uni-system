package View;
import uniUtil.*;
import Enum.*;

import java.util.Scanner;
import Model.*;
public class ViewLibrarian {
    private static Language currentLanguage = Language.ENG;
    private static Librarian myLibrarian = null;

    public static void chooseLanguage(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Select your language / Выберите язык / Тілді таңдаңыз:");
        System.out.println("1. English");
        System.out.println("2. Русский");
        System.out.println("3. Қазақ тілі");
        int choice = scan.nextInt();
        if (choice == 1){
            currentLanguage = Language.ENG;
        } else if(choice == 2){
            currentLanguage = Language.RU;
        } else if(choice == 3){
            currentLanguage = Language.KZ;
        }
    }

    public static void menu(Librarian librarian){
        Scanner scan = new Scanner(System.in);
        myLibrarian = librarian;

        // Печать меню в зависимости от выбранного языка
        if (currentLanguage == Language.ENG){
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
        } else if (currentLanguage == Language.KZ){
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
            // Действие для новостей
        } else if (option == 2) {
            // Действие для списка взятых книг
        } else if (option == 3) {
            // Действие для списка свободных книг
        } else if (option == 4) {
            librarian = null;
            BaseView.welcome(); // Возвращаем в главное меню
        }
    }
}
