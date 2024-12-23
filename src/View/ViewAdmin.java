package View;

import Controller.UserController;
import Enum.*;
import Model.*;
import data.Database;

import java.util.Scanner;
import java.util.Vector;

public class ViewAdmin {
    private static Language currentLanguage = Language.ENG;
    static Scanner scanner = new Scanner(System.in);

    public static void chooseLanguage() {
        System.out.println("Select your language / Выберите язык / Тілді таңдаңыз:");
        System.out.println("1. English");
        System.out.println("2. Русский");
        System.out.println("3. Қазақ тілі");
        int choice = scanner.nextInt();
        if (choice == 1) {
            currentLanguage = Language.ENG;
        } else if (choice == 2) {
            currentLanguage = Language.RU;
        } else if (choice == 3) {
            currentLanguage = Language.KZ;
        }
    }

    public static void menu() {
        Scanner scan = new Scanner(System.in);
        if (currentLanguage == Language.ENG) {
            System.out.println("Welcome to WSP!\nSelect the option:");
            System.out.println("1. News");
            System.out.println("2. Chat");
            System.out.println("3. Send request");
            System.out.println("4. Add user");
            System.out.println("5. Delete user");
            System.out.println("6. View users");
            System.out.println("7. Change language");
            System.out.println("8. Exit to Main Menu");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Добро пожаловать в WSP\nВыберите опцию:");
            System.out.println("1. Новости");
            System.out.println("2. Чат");
            System.out.println("3. Отправка запроса");
            System.out.println("4. Добавить пользователя");
            System.out.println("5. Удалить пользователя");
            System.out.println("6. Посмотреть пользователей");
            System.out.println("7. Сменить язык");
            System.out.println("8. Вернуться в главное меню");
        } else if (currentLanguage == Language.KZ) {
            System.out.println("WSP-ға қош келдіңіз\nОпцияны таңдаңыз:");
            System.out.println("1. Жаңалықтар");
            System.out.println("2. Чат");
            System.out.println("3. Сұраныс жіберу");
            System.out.println("4. Қолданушы қосу");
            System.out.println("5. Қолданушыны жою");
            System.out.println("6. Қолданушыларды көру");
            System.out.println("7. Тілді өзгерту");
            System.out.println("8. Негізгі мәзірге қайту");
        }
        int choice = scanner.nextInt();
        if (choice == 1) {
            // обработка новостей
        } else if (choice == 2) {
            // обработка чата
        } else if (choice == 3) {
            // обработка запроса
        } else if (choice == 4) {
            addUser();
        } else if (choice == 5) {
            deleteUser();
        } else if (choice == 6) {
            viewUsers();
        } else if (choice == 7) {
            chooseLanguage();  // Смена языка
            menu();  // Перезапуск меню после изменения языка
        } else if (choice == 8) {
            BaseView.welcome();  // Возвращение в главное меню
        }
    }

    public static void addUser() {
        scanner.nextLine(); // Очистка буфера после `nextInt()`

        // Введение меню в зависимости от языка
        if (currentLanguage == Language.ENG) {
            System.out.println("Welcome to WSP!\nSelect your role:");
            System.out.println("1. Teacher");
            System.out.println("2. Manager");
            System.out.println("3. Student");
            System.out.println("4. Librarian");
            System.out.println("5. Dean");
            System.out.println("6. Exit");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Выберите роль:");
            System.out.println("1. Учитель");
            System.out.println("2. Менеджер");
            System.out.println("3. Студент");
            System.out.println("4. Библиотекарь");
            System.out.println("5. Декан");
            System.out.println("6. Выход");
        } else if (currentLanguage == Language.KZ) {
            System.out.println("Рөлді таңдаңыз:");
            System.out.println("1. Мұғалім");
            System.out.println("2. Менеджер");
            System.out.println("3. Студент");
            System.out.println("4. Кітапханашы");
            System.out.println("5. Декан");
            System.out.println("6. Шығу");
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

        // Запрашиваем факультет только для студента
        if (option == 3) {
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

        // Если выбран учитель, менеджер или декан, запрашиваем степень
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
            case 2 -> UserController.createUser(username, password, UserType.MANAGER, null, null);
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
        } else if (currentLanguage == Language.RU) {
            System.out.println("1. Учитель");
            System.out.println("2. Менеджер");
            System.out.println("3. Студент");
            System.out.println("4. Библиотекарь");
            System.out.println("5. Декан");
            System.out.println("6. Вернуться в меню");
        } else if (currentLanguage == Language.KZ) {
            System.out.println("1. Мұғалім");
            System.out.println("2. Менеджер");
            System.out.println("3. Студент");
            System.out.println("4. Кітапханашы");
            System.out.println("5. Декан");
            System.out.println("6. Мәзірге қайту");
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
            menu();  // Возвращение в главное меню
            return;
        }

        // Дополнительный выбор: снова посмотреть или вернуться в меню
        boolean validChoice = false;
        while (!validChoice) {
            System.out.println("Do you want to:");
            System.out.println("1. View more users");
            System.out.println("2. Go back to the menu");

            int choice = scanner.nextInt();

            if (choice == 1) {
                validChoice = true;
                viewUsers();
            } else if (choice == 2) {
                validChoice = true;
                menu();  // Возвращение в главное меню
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void deleteUser() {
        scanner.nextLine(); // Очистка буфера

        while (true) {
            // Начинаем бесконечный цикл, который будет повторяться, пока не введен правильный выбор
            System.out.print("Enter username to delete: ");
            String username = scanner.nextLine();

            System.out.println("Select the user type to delete:");
            System.out.println("1. Teacher");
            System.out.println("2. Manager");
            System.out.println("3. Student");
            System.out.println("4. Librarian");
            System.out.println("5. Dean");

            int choice = scanner.nextInt();

            UserType userType = null;

            switch (choice) {
                case 1 -> userType = UserType.TEACHER;
                case 2 -> userType = UserType.MANAGER;
                case 3 -> userType = UserType.STUDENT;
                case 4 -> userType = UserType.LIBRARIAN;
                case 5 -> userType = UserType.DEAN;
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                    continue;  // Если выбор неправильный, переходим к следующей итерации цикла
                }
            }

            boolean result = UserController.deleteUser(username, userType);
            if (result) {
                System.out.println("User deleted successfully!");
                menu();
                return;
            } else {
                System.out.println("User not found.");
            }
        }
    }
}
