package View;
import uniUtil.*;
import Enum.*;
import Model.*;

import java.util.Scanner;

public class ViewTeacher {
    private static Language currentLanguage = Language.ENG; // по умолчанию
    private static Teacher myTeacher = null;

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

    public static void menu(Teacher teacher){
        Scanner scan = new Scanner(System.in);
        myTeacher = teacher;
        // Печать меню в зависимости от выбранного языка
        if (currentLanguage == Language.ENG){
            System.out.println("Welcome to WSP!\n Select the option:");
            System.out.println("1. News");
            System.out.println("2. Research Projects");
            System.out.println("3. Send Complaints");
            System.out.println("4. List of students");
            System.out.println("5. Chat");
            System.out.println("6. Send request");
            System.out.println("7. Exit to Main Menu");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Добро пожаловать в WSP\n Выберите опцию:");
            System.out.println("1. Новости");
            System.out.println("2. Научные статьи");
            System.out.println("3. Отправка Жалобы");
            System.out.println("4. Список студентов");
            System.out.println("5. Чат");
            System.out.println("6. Отправка запроса");
            System.out.println("7. Выход в главное меню");
        } else if (currentLanguage == Language.KZ){
            System.out.println("WSP-ға қош келдіңіз\n Опцияны таңдаңыз:");
            System.out.println("1. Жаңалықтар");
            System.out.println("2. Ғылыми мақалалар");
            System.out.println("3. Шағымдану");
            System.out.println("4. Студенттер тізімі");
            System.out.println("5. Чат");
            System.out.println("6. Сұраныс жіберу");
            System.out.println("7. Негізгі мәзірге қайту");
        }

        // Ввод опции пользователем
        int option = scan.nextInt();

        // Обработка опций
        if (option == 1) {
            // Действие для новостей
        } else if (option == 2) {
            // Действие для научных статей
        } else if (option == 3) {
            // Действие для отправки жалобы
        } else if (option == 4) {
            // Действие для списка студентов
        } else if (option == 5) {
            // Действие для чата
        } else if (option == 6) {
            // Действие для отправки запроса
        } else if (option == 7) {
            myTeacher = null;
            BaseView.welcome(); // Возвращаем в главное меню
        }
    }
}
