package View;
import uniUtil.*;
import Enum.*;
import Controller.*;
import Model.*;
import data.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import Model.*;
public class ViewManager {
    private static Language currentLanguage = Language.ENG;
    private static Manager myManager = null;

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

    public static void menu(Manager manager){
        Scanner scan = new Scanner(System.in);
        myManager = manager;

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
        CourseController courseController = new CourseController();
        // Обработка опций
        if (option == 1) {
            manageNewsMenu();
        } else if (option == 2) {
            viewSignedRequests();
        } else if (option == 3) {
            // Действие для управления регистрацией
            manageRegistration(courseController);
        } else if (option == 4) {
            // Действие для присваивания учителей
            assignTeacher(courseController);
        } else if (option == 5) {
            myManager = null;
            BaseView.welcome(); // Возвращаем в главное меню
        } else{
            System.out.println(myManager.toString());
        }
    }
    // Управление регистрацией
    private static void manageRegistration(CourseController courseController) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            // Печать меню в зависимости от текущего языка
            if (currentLanguage == Language.ENG) {
                System.out.println("1. Open registration");
                System.out.println("2. Close registration");
                System.out.println("3. Back to menu");
            } else if (currentLanguage == Language.RU) {
                System.out.println("1. Открыть регистрацию");
                System.out.println("2. Закрыть регистрацию");
                System.out.println("3. Назад в меню");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("1. Тіркеуді ашу");
                System.out.println("2. Тіркеуді жабу");
                System.out.println("3. Мәзірге оралу");
            }

            int option = scan.nextInt();

            if (option == 3) {
                menu(myManager); // Возврат в главное меню
                break;  // Прерывание цикла
            } else if (option == 1) {
                courseController.openRegistration();
                System.out.println(currentLanguage == Language.ENG
                        ? "Registration is now open."
                        : currentLanguage == Language.RU
                        ? "Регистрация теперь открыта."
                        : "Тіркеу ашық.");
            } else if (option == 2) {
                courseController.closeRegistration();
                System.out.println(currentLanguage == Language.ENG
                        ? "Registration is now closed."
                        : currentLanguage == Language.RU
                        ? "Регистрация теперь закрыта."
                        : "Тіркеу жабық.");
            } else {
                System.out.println(currentLanguage == Language.ENG
                        ? "Invalid option. Try again."
                        : currentLanguage == Language.RU
                        ? "Неверный вариант. Попробуйте еще раз."
                        : "Қате нұсқа. Қайта көріңіз.");
            }

            // Запрос о продолжении или выходе в главное меню
            System.out.println(currentLanguage == Language.ENG
                    ? "Would you like to continue? (1 - Yes, 2 - No)"
                    : currentLanguage == Language.RU
                    ? "Хотите продолжить? (1 - Да, 2 - Нет)"
                    : "Жалғастырғыңыз келе ме? (1 - Иә, 2 - Жоқ)");

            int continueOption = scan.nextInt();
            if (continueOption == 2) {
                menu(myManager); // Выход в главное меню
                break;
            }
        }
    }


    // Присваивание учителей курсу
    private static void assignTeacher(CourseController courseController) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            // Печать меню в зависимости от выбранного языка
            if (currentLanguage == Language.ENG) {
                System.out.println("1. Enter course name");
                System.out.println("2. Back to menu");
            } else if (currentLanguage == Language.RU) {
                System.out.println("1. Введите название курса");
                System.out.println("2. Назад в меню");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("1. Курстың атын енгізіңіз");
                System.out.println("2. Мәзірге оралу");
            }

            int option = scan.nextInt();
            scan.nextLine(); // Поглощение символа новой строки

            if (option == 2) {
                menu(myManager); // Возврат в главное меню
                break;  // Прерывание цикла
            } else if (option == 1) {
                System.out.println(currentLanguage == Language.ENG
                        ? "Please enter the course name:"
                        : currentLanguage == Language.RU
                        ? "Введите название курса:"
                        : "Курстың атын енгізіңіз:");

                String courseName = scan.nextLine();

                Course course = null;
                for (Course c : Database.Courses) {
                    if (c.getName().equals(courseName)) {
                        course = c;
                        break;
                    }
                }

                if (course != null) {
                    System.out.println(currentLanguage == Language.ENG
                            ? "Please enter the teacher's name:"
                            : currentLanguage == Language.RU
                            ? "Введите имя преподавателя:"
                            : "Мұғалімнің атын енгізіңіз:");

                    String teacherName = scan.nextLine();
                    Teacher teacher = null;

                    for (Teacher t : Database.TeacherDB) {
                        if (t.getName().equals(teacherName)) {
                            teacher = t;
                            break;
                        }
                    }

                    if (teacher != null) {
                        boolean result = courseController.addTeacher(course, teacher);

                        if (result) {
                            Database.saveCourse();
                            System.out.println(currentLanguage == Language.ENG
                                    ? "Teacher " + teacher.getName() + " assigned to course " + course.getName()
                                    : currentLanguage == Language.RU
                                    ? "Преподаватель " + teacher.getName() + " назначен на курс " + course.getName()
                                    : "Мұғалім " + teacher.getName() + " " + course.getName() + " курсына тағайындалды.");
                        } else {
                            System.out.println(currentLanguage == Language.ENG
                                    ? "Failed to assign teacher."
                                    : currentLanguage == Language.RU
                                    ? "Не удалось назначить преподавателя."
                                    : "Мұғалімді тағайындау сәтсіз болды.");
                        }
                    } else {
                        System.out.println(currentLanguage == Language.ENG
                                ? "Teacher not found."
                                : currentLanguage == Language.RU
                                ? "Преподаватель не найден."
                                : "Мұғалім табылмады.");
                    }
                } else {
                    System.out.println(currentLanguage == Language.ENG
                            ? "Course not found."
                            : currentLanguage == Language.RU
                            ? "Курс не найден."
                            : "Курс табылмады.");
                }
            } else {
                System.out.println(currentLanguage == Language.ENG
                        ? "Invalid option. Try again."
                        : currentLanguage == Language.RU
                        ? "Неверный вариант. Попробуйте еще раз."
                        : "Қате нұсқа. Қайта көріңіз.");
            }

            // Запрос о продолжении или выходе в главное меню
            System.out.println(currentLanguage == Language.ENG
                    ? "Would you like to continue? (1 - Yes, 2 - No)"
                    : currentLanguage == Language.RU
                    ? "Хотите продолжить? (1 - Да, 2 - Нет)"
                    : "Жалғастырғыңыз келе ме? (1 - Иә, 2 - Жоқ)");

            int continueOption = scan.nextInt();
            if (continueOption == 2) {
                menu(myManager); // Выход в главное меню
                break;
            }
        }
    }

    private static void manageNewsMenu() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            // Подменю "Управление новостями"
            if (currentLanguage == Language.ENG) {
                System.out.println("Manage News:");
                System.out.println("1. Add News");
                System.out.println("2. View News Requests");
                System.out.println("3. Back to Main Menu");
            } else if (currentLanguage == Language.RU) {
                System.out.println("Управление новостями:");
                System.out.println("1. Добавить новость");
                System.out.println("2. Просмотр опубликованных новостей");
                System.out.println("3. Назад в главное меню");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("Жаңалықтарды басқару:");
                System.out.println("1. Жаңалық қосу");
                System.out.println("2. Жарияланған жаңалықтарды қарау");
                System.out.println("3. Бас мәзірге оралу");
            }

            int subOption = scan.nextInt();

            if (subOption == 1) {
                addNews(scan);
            }  else if (subOption == 2) {
                NewsController.viewNews(currentLanguage, myManager,UserType.MANAGER);
            } else if (subOption == 3) {
                break;
            }
        }
    }

    private static void addNews(Scanner scan) {
        scan.nextLine(); // Очистка буфера

        if (currentLanguage == Language.ENG) {
            System.out.println("Enter the title of the news:");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Введите заголовок новости:");
        } else if (currentLanguage == Language.KZ) {
            System.out.println("Жаңалықтың тақырыбын енгізіңіз:");
        }
        String title = scan.nextLine();

        if (currentLanguage == Language.ENG) {
            System.out.println("Enter the content of the news:");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Введите содержание новости:");
        } else if (currentLanguage == Language.KZ) {
            System.out.println("Жаңалықтың мазмұнын енгізіңіз:");
        }
        String content = scan.nextLine();

        if (currentLanguage == Language.ENG) {
            System.out.println("Select importance level:");
            System.out.println("1. High");
            System.out.println("2. Medium");
            System.out.println("3. Low");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Выберите уровень важности:");
            System.out.println("1. Высокий");
            System.out.println("2. Средний");
            System.out.println("3. Низкий");
        } else if (currentLanguage == Language.KZ) {
            System.out.println("Маңыздылық деңгейін таңдаңыз:");
            System.out.println("1. Жоғары");
            System.out.println("2. Орташа");
            System.out.println("3. Төмен");
        }
        int levelChoice = scan.nextInt();

        LevelImportance level;
        switch (levelChoice) {
            case 1:
                level = LevelImportance.HIGH;
                break;
            case 2:
                level = LevelImportance.MEDIUM;
                break;
            case 3:
                level = LevelImportance.LOW;
                break;
            default:
                level = LevelImportance.LOW; // По умолчанию
                break;
        }

        News newNews = new News(title,  LocalDateTime.now(),  content, level);
        Database.NewsDB.add(newNews);
        Database.saveNewsDB();

        if (currentLanguage == Language.ENG) {
            System.out.println("News added successfully!");
        } else if (currentLanguage == Language.RU) {
            System.out.println("Новость успешно добавлена!");
        } else if (currentLanguage == Language.KZ) {
            System.out.println("Жаңалық сәтті қосылды!");
        }
    }
    private static void viewSignedRequests() {
        Scanner scan = new Scanner(System.in);

        // Проверяем, есть ли подписанные запросы
        int totalRequests = Database.AcceptedEmployeeRequests.size();

        if (totalRequests == 0) {
            // Если запросов нет, выводим сообщение и возвращаем в меню
            System.out.println(currentLanguage == Language.ENG ? "No signed requests." :
                    currentLanguage == Language.RU ? "Нет подписанных запросов." :
                            "Қол қойылған сұраныстар жоқ.");
            menu(myManager); // Возврат в главное меню
            return;
        }

        // Разбиваем на страницы
        int pageSize = 5; // Количество запросов на одной странице
        int totalPages = (int) Math.ceil((double) totalRequests / pageSize);

        int currentPage = 1; // Начинаем с первой страницы
        while (true) {
            // Отображаем текущую страницу
            System.out.println(currentLanguage == Language.ENG ? "Viewing page " + currentPage + " of " + totalPages :
                    currentLanguage == Language.RU ? "Просмотр страницы " + currentPage + " из " + totalPages :
                            "Бет " + currentPage + " из " + totalPages);

            int start = (currentPage - 1) * pageSize;
            int end = Math.min(start + pageSize, totalRequests);

            // Печать запросов на текущей странице
            for (int i = start; i < end; i++) {
                Request req = Database.AcceptedEmployeeRequests.get(i);
                System.out.println((i + 1) + ". " + req.toString()); // Или другой формат вывода запроса
            }

            // Запрос пользователя для перехода
            System.out.println(currentLanguage == Language.ENG ?
                    "1. Next page\n2. Previous page\n3. Back to menu" :
                    currentLanguage == Language.RU ?
                            "1. Следующая страница\n2. Предыдущая страница\n3. Назад в меню" :
                            "1. Келесі бет\n2. Алдыңғы бет\n3. Мәзірге оралу");

            int option = scan.nextInt();

            if (option == 1 && currentPage < totalPages) {
                currentPage++; // Переходим на следующую страницу
            } else if (option == 2 && currentPage > 1) {
                currentPage--; // Переходим на предыдущую страницу
            } else if (option == 3) {
                menu(myManager); // Возврат в главное меню
                break;
            } else {
                System.out.println(currentLanguage == Language.ENG ? "Invalid option. Try again." :
                        currentLanguage == Language.RU ? "Неверный вариант. Попробуйте еще раз." :
                                "Қате нұсқа. Қайта көріңіз.");
            }
        }
    }

    private static void createCourse(CourseController courseController) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            // Печать меню для создания курса
            if (currentLanguage == Language.ENG) {
                System.out.println("Enter the course name:");
            } else if (currentLanguage == Language.RU) {
                System.out.println("Введите название курса:");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("Курстың атын енгізіңіз:");
            }

            String courseName = scan.nextLine();

            // Ввод семестра
            if (currentLanguage == Language.ENG) {
                System.out.println("Enter the semester number:");
            } else if (currentLanguage == Language.RU) {
                System.out.println("Введите номер семестра:");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("Семестр нөмірін енгізіңіз:");
            }
            int semester = scan.nextInt();

            // Ввод количества кредитов
            if (currentLanguage == Language.ENG) {
                System.out.println("Enter the number of credits:");
            } else if (currentLanguage == Language.RU) {
                System.out.println("Введите количество кредитов:");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("Кредиттер санын енгізіңіз:");
            }
            int credits = scan.nextInt();
            scan.nextLine();  // Поглощение символа новой строки

            // Выбор факультета с использованием switch
            if (currentLanguage == Language.ENG) {
                System.out.println("Choose the faculty:");
            } else if (currentLanguage == Language.RU) {
                System.out.println("Выберите факультет:");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("Факультетті таңдаңыз:");
            }

            System.out.println("1. Faculty of Computer Science");
            System.out.println("2. Faculty of Engineering");
            System.out.println("3. Faculty of Business");
            System.out.println("4. Faculty of Arts");

            int facultyChoice = scan.nextInt();
            Faculty selectedFaculty = null;

            switch (facultyChoice) {
                case 1:
                    selectedFaculty = Faculty.BS;
                    break;
                case 2:
                    selectedFaculty = Faculty.SITE;
                    break;
                case 3:
                    selectedFaculty = Faculty.KMA;
                    break;
                default:
                    if (currentLanguage == Language.ENG) {
                        System.out.println("Invalid faculty choice.");
                    } else if (currentLanguage == Language.RU) {
                        System.out.println("Неверный выбор факультета.");
                    } else if (currentLanguage == Language.KZ) {
                        System.out.println("Қате факультет таңдауы.");
                    }
                    continue;
            }

            // Создание нового курса
            Course newCourse = new Course(semester, courseName, credits, selectedFaculty);
            courseController.addCourse(newCourse);

            if (currentLanguage == Language.ENG) {
                System.out.println("Course " + newCourse.getName() + " created successfully.");
            } else if (currentLanguage == Language.RU) {
                System.out.println("Курс " + newCourse.getName() + " успешно создан.");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("Курс " + newCourse.getName() + " сәтті құрылды.");
            }

            // Запрос о продолжении или выходе в главное меню
            System.out.println(currentLanguage == Language.ENG
                    ? "What would you like to do next? (1 - Create another course, 2 - Go back to the main menu)"
                    : currentLanguage == Language.RU
                    ? "Что вы хотите делать дальше? (1 - Создать еще один курс, 2 - Вернуться в главное меню)"
                    : "Келесі не істеуді қалайсыз? (1 - Тағы курс жасау, 2 - Бас мәзірге оралу)");

            int choice = scan.nextInt();
            if (choice == 1) {
                continue; // Возврат к созданию нового курса
            } else if (choice == 2) {
                menu(myManager); // Возврат в главное меню
                break;
            } else {
                // Если ввод неверный, выводим сообщение и повторяем запрос
                System.out.println(currentLanguage == Language.ENG
                        ? "Invalid choice. Please try again."
                        : currentLanguage == Language.RU
                        ? "Неверный выбор. Попробуйте снова."
                        : "Қате таңдау. Қайтадан таңдаңыз.");
            }
        }
    }


}
