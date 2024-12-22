package View;
import uniUtil.*;
import Enum.*;

import java.util.Scanner;

public class ViewStudent {
    private static Language currentLanguage = Language.ENG;

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

    public static void menu(){
        Scanner scan = new Scanner(System.in);

        // Печать меню в зависимости от выбранного языка
        if (currentLanguage == Language.ENG){
            System.out.println("Welcome to WSP!\n Select the option:");
            System.out.println("1. News");
            System.out.println("2. Transcript");
            System.out.println("3. Notifications");
            System.out.println("4. Research Projects");
            System.out.println("5. Register for disciplines");
            System.out.println("6. Take book from library");
            System.out.println("7. Exit to Main Menu");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Добро пожаловать в WSP\n Выберите опцию:");
            System.out.println("1. Новости");
            System.out.println("2. Транскрипт");
            System.out.println("3. Уведомления");
            System.out.println("4. Журнал научных статей");
            System.out.println("5. Регистрация на дисциплины");
            System.out.println("6. Взять книгу из библиотеки");
            System.out.println("7. Выход в главное меню");
        } else if (currentLanguage == Language.KZ){
            System.out.println("WSP-ға қош келдіңіз\n Опцияны таңдаңыз:");
            System.out.println("1. Жаңалықтар");
            System.out.println("2. Транскрипт");
            System.out.println("3. Хабарламалар");
            System.out.println("4. Ғылыми мақалалар");
            System.out.println("5. Пәндерге тіркелу");
            System.out.println("6. Кітапханадан кітап алу");
            System.out.println("7. Негізгі мәзірге қайту");
        }

        // Ввод опции пользователем
        int option = scan.nextInt();

        // Обработка опций
        if (option == 1) {
            // Действие для новостей
        } else if (option == 2) {
            // Действие для транскрипта
        } else if (option == 3) {
            // Действие для уведомлений
        } else if (option == 4) {
            // Действие для научных проектов
        } else if (option == 5) {
            // Действие для регистрации на дисциплины
        } else if (option == 6) {
            // Действие для взятия книги из библиотеки
        } else if (option == 7) {
            BaseView.welcome(); // Возвращаем в главное меню
        }
    }
}
