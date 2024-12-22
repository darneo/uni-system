package View;
import Model.Student;
import uniUtil.*;
import Enum.*;
import Controller.*;
import data.Database;
import Model.*;

import java.util.Scanner;

public class ViewStudent {
    private static Language currentLanguage = Language.ENG;
    private static Student myStudent = null;

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

    public static void menu(Student student){
        Scanner scan = new Scanner(System.in);
        myStudent = student;

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
            student = null;
            BaseView.welcome(); // Возвращаем в главное меню
        }
    }
    private static void handleCourseRegistration() {
        CourseController courseController = new CourseController();
        Scanner scan = new Scanner(System.in);

        if (Database.isOpenRegistration) {
            if (currentLanguage == Language.ENG) {
                System.out.println("Registration is open. Please enter the course name:");
            } else if (currentLanguage == Language.RU) {
                System.out.println("Регистрация открыта. Введите название курса:");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("Тіркеу ашық. Курстың атауын енгізіңіз:");
            }

            String courseName = scan.nextLine();
            Course pickedCourse = null;

            // Поиск курса по имени
            for (Course course : Database.Courses) {
                if (course.getName().equalsIgnoreCase(courseName)) {
                    pickedCourse = course;
                    break;
                }
            }

            if (pickedCourse != null) {
                // Используем текущего студента из базы данных
                boolean success = courseController.pickCourse(ОСЫ ЖЕРГЕ, pickedCourse);
                if (success) {
                    if (currentLanguage == Language.ENG) {
                        System.out.println("You have successfully registered for the course.");
                    } else if (currentLanguage == Language.RU) {
                        System.out.println("Вы успешно зарегистрировались на курс.");
                    } else if (currentLanguage == Language.KZ) {
                        System.out.println("Сіз курсқа сәтті тіркелдіңіз.");
                    }
                } else {
                    if (currentLanguage == Language.ENG) {
                        System.out.println("Registration failed. You may have already completed this course.");
                    } else if (currentLanguage == Language.RU) {
                        System.out.println("Регистрация не удалась. Возможно, вы уже прошли этот курс.");
                    } else if (currentLanguage == Language.KZ) {
                        System.out.println("Тіркелу сәтсіз аяқталды. Мүмкін сіз бұл курсты бұрыннан өтіп қойған боларсыз.");
                    }
                }
            } else {
                if (currentLanguage == Language.ENG) {
                    System.out.println("Course not found. Please check the name and try again.");
                } else if (currentLanguage == Language.RU) {
                    System.out.println("Курс не найден. Проверьте название и попробуйте снова.");
                } else if (currentLanguage == Language.KZ) {
                    System.out.println("Курс табылмады. Атауын тексеріп, қайтадан көріңіз.");
                }
            }
        } else {
            if (currentLanguage == Language.ENG) {
                System.out.println("Registration is currently closed.");
            } else if (currentLanguage == Language.RU) {
                System.out.println("Регистрация в данный момент закрыта.");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("Қазіргі уақытта тіркелу жабық.");
            }
        }
    }

}