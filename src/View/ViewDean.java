package View;
import uniUtil.*;
import Enum.*;
import java.util.Scanner;
import Model.*;

public class ViewDean {
    private static Dean myDean = null;
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

    public static void menu(Dean dean){
        Scanner scan = new Scanner(System.in);
        myDean = dean;

        // Печать меню в зависимости от выбранного языка
        if (currentLanguage == Language.ENG){
            System.out.println("Welcome to WSP!\n Select the option:");
            System.out.println("1. News");
            System.out.println("2. View complaints");
            System.out.println("3. View requests");
            System.out.println("4. Research Projects");
            System.out.println("5. Exit to Main Menu");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Добро пожаловать в WSP\n Выберите опцию:");
            System.out.println("1. Новости");
            System.out.println("2. Просмотр жалоб");
            System.out.println("3. Просмотр запросов");
            System.out.println("4. Журнал научных статей");
            System.out.println("5. Выход в главное меню");
        } else if (currentLanguage == Language.KZ){
            System.out.println("WSP-ға қош келдіңіз\n Опцияны таңдаңыз:");
            System.out.println("1. Жаңалықтар");
            System.out.println("2. Шағымдарды қарастыру");
            System.out.println("3. Сұраныстарды қарастыру");
            System.out.println("4. Ғылыми мақалалар");
            System.out.println("5. Негізгі мәзірге қайту");
        }

        // Ввод опции пользователем
        int option = scan.nextInt();

        // Обработка опций
        if (option == 1) {
            // Действие для новостей
        } else if (option == 2) {
            // Действие для просмотра жалоб
        } else if (option == 3) {
            // Действие для просмотра запросов
        } else if (option == 4) {
            // Действие для научных проектов
        } else if (option == 5) {
            myDean = null;
            BaseView.welcome();// Возвращаем в главное меню
        }
    }
}
