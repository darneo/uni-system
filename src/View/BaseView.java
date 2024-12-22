package View;
import Enum.*;
import Controller.*;
import Model.*;
import data.Database;

import java.util.Scanner;

public class
BaseView {
    private static Language currentLanguage = Language.ENG;
    static Scanner scan = new Scanner(System.in);

    public static void chooseLanguage() {
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

    public static void welcome() {
        if (currentLanguage == Language.ENG) {
            System.out.println("Welcome to WSP!\n Select your role:");
            System.out.println("1. Teacher");
            System.out.println("2. Manager");
            System.out.println("3. Student");
            System.out.println("4. Admin");
            System.out.println("5. Librarian");
            System.out.println("6. Dean");

            int option = scan.nextInt();
            if (option == 1) {
                authorize("teacher.txt");
            } else if (option == 2) {
                authorize("manager.txt");
            } else if (option == 3) {
                authorize("student.txt");
            } else if (option == 4) {
                authorize("admin");
            } else if (option == 5) {
                authorize("librarian.txt");
            } else if (option == 6) {
                authorize("Dean.txt");
            }
        }
        if (currentLanguage == Language.RU) {
            System.out.println("Добро пожаловать в WSP!\n Выберите свою роль:");
            System.out.println("1. Преподаватель");
            System.out.println("2. Менеджер");
            System.out.println("3. Студент");
            System.out.println("4. Администратор");
            System.out.println("5. Библиотекарь");
            System.out.println("6. Декан");

            int option = scan.nextInt();
            if (option == 1) {
                authorize("teacher.txt");
            } else if (option == 2) {
                authorize("manager.txt");
            } else if (option == 3) {
                authorize("student.txt");
            } else if (option == 4) {
                authorize("admin");
            } else if (option == 5) {
                authorize("librarian.txt");
            } else if (option == 6) {
                authorize("Dean.txt");
            }
        }
    }

    public static void authorize(String fileName) {
        if (currentLanguage == Language.ENG) {
            scan.nextLine(); // Для удаления оставшегося символа новой строки после nextInt()
            System.out.println("Please enter your credentials:");
            System.out.println("Username:");
            String username = scan.nextLine();
            System.out.println("Password:");
            String password = scan.nextLine();

            boolean res = false;

            if (fileName.equals("admin") && Database.adminWord.equals(username) && Database.adminPassword.equals(password)) {
                res = true;
            } else {
                res = UserController.authorize(fileName, username, password);
            }

            if (res == false) {
                System.out.println("Your credentials are wrong! Try again.");
                welcome();  // Перезапуск авторизации
            } else {
                // Вызываем соответствующее меню в зависимости от типа пользователя
                if (fileName.equals("student.txt")){
                    Object obj = UserController.getUser(UserType.STUDENT, username);
                    if(obj instanceof Student){
                        ViewStudent.menu((Student) obj);
                    }
                } else if (fileName.equals("teacher.txt")) {
                    Object obj = UserController.getUser(UserType.TEACHER, username);
                    if(obj instanceof Student){
                        ViewTeacher.menu((Teacher) obj);
                    }
                } else if (fileName.equals("manager.txt")) {
                    Object obj = UserController.getUser(UserType.MANAGER, username);
                    if(obj instanceof Student){
                        ViewManager.menu((Manager) obj);
                    }
                } else if (fileName.equals("admin")) {
                    ViewAdmin.menu();
                } else if (fileName.equals("librarian.txt")) {
                    Object obj = UserController.getUser(UserType.LIBRARIAN, username);
                    if(obj instanceof Student){
                        ViewLibrarian.menu((Librarian) obj);
                    }
                } else if (fileName.equals("Dean.txt")) {
                    Object obj = UserController.getUser(UserType.DEAN, username);
                    if(obj instanceof Student){
                        ViewDean.menu((Dean) obj);
                    }
                }
            }
        }
    }
}
