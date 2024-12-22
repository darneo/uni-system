package View;
import uniUtil.*;
import Enum.*;

import java.util.Scanner;

public class ViewManager {
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
            System.out.println("1. Manage News");
            System.out.println("2. View signed requests");
            System.out.println("3. Manage registration");
            System.out.println("4. Assign teachers");
            System.out.println("5. Exit to Main Menu");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Добро пожаловать в WSP\n Выберите опцию:");
            System.out.println("1. Новости");
            System.out.println("2. Просмотр подписанных запросов");
            System.out.println("3. Управление регистрацией");
            System.out.println("4. Присваивание учителей");
            System.out.println("5. Выход в главное меню");
        } else if (currentLanguage == Language.KZ){
            System.out.println("WSP-ға қош келдіңіз\n Опцияны таңдаңыз:");
            System.out.println("1. Жаңалықтар");
            System.out.println("2. Қол қойылған сұраныстарды қарау");
            System.out.println("3. Тіркелумен жұмыс жасау");
            System.out.println("4. Мұғалімдерді тиістіру");
            System.out.println("5. Негізгі мәзірге қайту");
        }

        // Ввод опции пользователем
        int option = scan.nextInt();

        // Обработка опций
        if (option == 1) {
            // Действие для управления новостями
        } else if (option == 2) {
            // Действие для просмотра подписанных запросов
        } else if (option == 3) {
            // Действие для управления регистрацией
        } else if (option == 4) {
            // Действие для присваивания учителей
        } else if (option == 5) {
            BaseView.welcome(); // Возвращаем в главное меню
        }
    }
}
