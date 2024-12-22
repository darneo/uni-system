package View;

import Controller.UserController;
import Enum.*;
import Model.*;
import data.Database;

import java.sql.SQLOutput;
import java.util.*;

public class ViewAdmin {
    private static Language currentLanguage = Language.ENG;
    static Scanner scanner = new Scanner(System.in);
    public static void chooseLanguage(){
        System.out.println("Select your language / Выберите язык / Тілді таңдаңыз:");
        System.out.println("1. English");
        System.out.println("2. Русский");
        System.out.println("3. Қазақ тілі");
        int choice = scanner.nextInt();
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
        if (currentLanguage == Language.ENG){
            System.out.println("Welcome to WSP!\n Select the option:");
            System.out.println("1. News");
            System.out.println("3. Chat");
            System.out.println("4. Send request");
            System.out.println("5. Add user");
            System.out.println("6. Delete user");
            System.out.println("7. view users");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Добро пожаловать в WSP\n Выберите опцию:");
            System.out.println("1. Новости");
            System.out.println("2. Чат");
            System.out.println("3. Отправка запроса");
        } else if (currentLanguage == Language.KZ){
            System.out.println("WSP-ға қош келдіңіз\n Опцияны таңдаңыз:");
            System.out.println("1. Жаңалықтар");
            System.out.println("2,Чат");
            System.out.println("3. Сұраныс жіберу");
        }
        int choice = scanner.nextInt();
        if (choice == 1){

        } else if(choice  == 2){

        } else if (choice == 3){

        } else if (choice == 4){

        } else if (choice == 5){
            addUser();
        } else if (choice == 6){

        } else if (choice == 7){
            viewUsers();
        }
    }

    public static void addUser() {
        scanner.nextLine(); // Очистка буфера после `nextInt()`

        // Введение меню в зависимости от языка
        if (currentLanguage == Language.ENG) {
            System.out.println("Welcome to WSP!\n Select your role:");
            System.out.println("1. Teacher");
            System.out.println("2. Manager");
            System.out.println("3. Student");
            System.out.println("4. Librarian");
            System.out.println("5. Dean");
            System.out.println("6. Exit");
        }

        int option = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера после `nextInt()`

        if (option == 6) {
            menu();
            return;
        }

        // Запрашиваем имя пользователя и пароль
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Для ролей, связанных с факультетом
        Faculty pickedFaculty = null;
        Degree pickedDegree = null;

        if (option == 1 || option == 2 || option == 3 || option == 5) {
            System.out.println("Select the faculty:");
            System.out.println("1. BS");
            System.out.println("2. SITE");
            System.out.println("3. KMA");

            int facultyChoice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (facultyChoice) {
                case 1 -> pickedFaculty = Faculty.BS;
                case 2 -> pickedFaculty = Faculty.SITE;
                case 3 -> pickedFaculty = Faculty.KMA;
                default -> {
                    System.out.println("Invalid faculty choice.");
                    return;
                }
            }
        }

        // Если выбран учитель, дополнительно запрашиваем уровень лектора
        if (option == 1) {
            System.out.println("Select the degree:");
            System.out.println("1. Lecturer");
            System.out.println("2. Senior Lecturer");
            System.out.println("3. Professor");

            int degreeChoice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (degreeChoice) {
                case 1 -> pickedDegree = Degree.LECTURER;
                case 2 -> pickedDegree = Degree.SENIORLECTURER;
                case 3 -> pickedDegree = Degree.PROFESSOR;
                default -> {
                    System.out.println("Invalid degree choice.");
                    return;
                }
            }
        }

        // Создаем пользователя в зависимости от выбранной роли
        switch (option) {
            case 1 -> UserController.createUser(username, password, UserType.TEACHER, pickedFaculty, pickedDegree);
            case 2 -> UserController.createUser(username, password, UserType.MANAGER, pickedFaculty, null);
            case 3 -> UserController.createUser(username, password, UserType.STUDENT, pickedFaculty, null);
            case 4 -> UserController.createUser(username, password, UserType.LIBRARIAN, null, null);
            case 5 -> UserController.createUser(username, password, UserType.DEAN, pickedFaculty, null);
            default -> System.out.println("Invalid role choice.");
        }

        System.out.println("User added successfully!");
        menu();
    }

    public static void viewUsers() {
        if (currentLanguage == Language.ENG) {
            System.out.println("1. Teacher");
            System.out.println("2. Manager");
            System.out.println("3. Student");
            System.out.println("4. Librarian");
            System.out.println("5. Dean");
            System.out.println("6. Back to menu");
        }

        int num = scanner.nextInt();

        // Просмотр пользователей по типам
        if (num == 1) {
            Vector<Teacher> teachers = Database.getTeachers();
            if (teachers.isEmpty()) {
                System.out.println("No teachers found.");
            } else {
                for (Teacher teacher : teachers) {
                    System.out.println(teacher);
                }
            }
        } else if (num == 2) {
            Vector<Manager> managers = Database.getManagers();
            if (managers.isEmpty()) {
                System.out.println("No managers found.");
            } else {
                for (Manager manager : managers) {
                    System.out.println(manager);
                }
            }
        } else if (num == 3) {
            Vector<Student> students = Database.getStudents();
            if (students.isEmpty()) {
                System.out.println("No students found.");
            } else {
                for (Student student : students) {
                    System.out.println(student);
                }
            }
        } else if (num == 4) {
            Vector<Librarian> librarians = Database.getLibrarians();
            if (librarians.isEmpty()) {
                System.out.println("No librarians found.");
            } else {
                for (Librarian librarian : librarians) {
                    System.out.println(librarian);
                }
            }
        } else if (num == 5) {
            Vector<Dean> deans = Database.getDeans();
            if (deans.isEmpty()) {
                System.out.println("No deans found.");
            } else {
                for (Dean dean : deans) {
                    System.out.println(dean);
                }
            }
        } else if (num == 6) {
            // Возвращаемся в главное меню
            menu();
            return;  // Прерываем текущий метод, чтобы не продолжать просмотр
        } else {
            System.out.println("Invalid choice. Please try again.");
            viewUsers();  // Если выбор неправильный, снова вызываем метод
            return;  // Прерываем текущий метод, чтобы не продолжать выполнение
        }

        // Дополнительный выбор: снова посмотреть или вернуться в меню
        boolean validChoice = false;
        while (!validChoice) {
            System.out.println("Do you want to:");
            System.out.println("1. View more users");
            System.out.println("2. Go back to the menu");

            int choice = scanner.nextInt();

            if (choice == 1) {
                // Если выбрал продолжить просмотр, снова вызываем метод
                validChoice = true;
                viewUsers();
            } else if (choice == 2) {
                // Если выбрал вернуться в меню, вызываем menu()
                validChoice = true;
                menu();
            } else {
                // Если выбор неправильный, снова вызываем viewUsers
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }



}