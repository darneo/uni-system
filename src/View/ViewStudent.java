package View;
import Model.Student;
import uniUtil.*;
import Enum.*;
import Controller.*;
import data.Database;
import Model.*;

import java.util.Scanner;
import java.util.Vector;
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
            NewsController.viewNews(currentLanguage, myStudent, UserType.STUDENT);
        } else if (option == 2) {
            // Действие для транскрипта
            handleTranscriptOption();
        } else if (option == 3) {
            // Действие для уведомлений
        } else if (option == 4) {
            // Действие для научных проектов
        } else if (option == 5) {
            handleCourseRegistration();
        } if (option == 6) {
            Scanner scanner = new Scanner(System.in);

            // Печать доступных книг в зависимости от языка
            if (currentLanguage == Language.ENG) {
                System.out.println("Available books in the library:");
            } else if (currentLanguage == Language.RU) {
                System.out.println("Доступные книги в библиотеке:");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("Кітапханада бар кітаптар:");
            }

            for (Book book : Database.CountOfbooks.keySet()) {
                int count = Database.CountOfbooks.get(book);
                if (count > 0) {
                    if (currentLanguage == Language.ENG) {
                        System.out.println("- " + book.getTitle() + " by " + book.getAuthor() + " (" + count + " copies available)");
                    } else if (currentLanguage == Language.RU) {
                        System.out.println("- " + book.getTitle() + " автор " + book.getAuthor() + " (" + count + " экземпляров доступно)");
                    } else if (currentLanguage == Language.KZ) {
                        System.out.println("- " + book.getTitle() + " авторы " + book.getAuthor() + " (" + count + " данасы қолжетімді)");
                    }
                }
            }

            // Запрос ввода от пользователя
            if (currentLanguage == Language.ENG) {
                System.out.println("Enter the title of the book you want to take:");
            } else if (currentLanguage == Language.RU) {
                System.out.println("Введите название книги, которую хотите взять:");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("Алуға қалаған кітабыңыздың атауын енгізіңіз:");
            }

            String bookTitle = scanner.nextLine();

            // Проверка доступности книги
            Book selectedBook = null;
            for (Book book : Database.CountOfbooks.keySet()) {
                if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                    selectedBook = book;
                    break;
                }
            }

            if (selectedBook == null || Database.CountOfbooks.get(selectedBook) <= 0) {
                if (currentLanguage == Language.ENG) {
                    System.out.println("Sorry, the book is not available.");
                } else if (currentLanguage == Language.RU) {
                    System.out.println("Извините, книга недоступна.");
                } else if (currentLanguage == Language.KZ) {
                    System.out.println("Кешіріңіз, бұл кітап қолжетімсіз.");
                }
            } else {
                // Добавление книги студенту
                Vector<Book> books = Database.ListOFstudents.getOrDefault(myStudent, new Vector<>());
                books.add(selectedBook);
                Database.ListOFstudents.put(myStudent, books);

                // Уменьшение количества книг
                Database.CountOfbooks.put(selectedBook, Database.CountOfbooks.get(selectedBook) - 1);

                // Сохранение изменений
                Database.saveCountOfbooks();
                Database.saveListOfStudents();

                if (currentLanguage == Language.ENG) {
                    System.out.println("You have successfully taken the book: " + selectedBook.getTitle());
                } else if (currentLanguage == Language.RU) {
                    System.out.println("Вы успешно взяли книгу: " + selectedBook.getTitle());
                } else if (currentLanguage == Language.KZ) {
                    System.out.println("Сіз кітабын сәтті алдыңыз: " + selectedBook.getTitle());
                }
            }
        }
        else if (option == 7) {
            student = null;
            BaseView.welcome(); // Возвращаем в главное меню
        }
    }

    public static void handleTranscriptOption() {
        if (myStudent == null) {
            if (currentLanguage == Language.ENG) {
                System.out.println("No student is currently logged in.");
            } else if (currentLanguage == Language.RU) {
                System.out.println("Студент не вошел в систему.");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("Студент жүйеге кірген жоқ.");
            }
            menu(myStudent); // Возвращение в меню
            return;
        }

        // Получение всех транскриптов
        Vector<Transcript> transcripts = myStudent.getTranscripts();
        if (transcripts == null || transcripts.isEmpty()) {
            if (currentLanguage == Language.ENG) {
                System.out.println("No transcripts found for this student.");
            } else if (currentLanguage == Language.RU) {
                System.out.println("Транскрипты для этого студента не найдены.");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("Бұл студент үшін транскрипттер табылмады.");
            }
            menu(myStudent); // Возвращение в меню
            return;
        }

        // Используем последний транскрипт
        Transcript latestTranscript = transcripts.lastElement();
        double gpa = latestTranscript.calculateGPA();

        // Подсчет общего числа кредитов
        double totalCredits = 0;
        for (Course course : latestTranscript.getCourses().keySet()) {
            totalCredits += course.getCredits();
        }

        // Вывод информации в зависимости от языка
        if (currentLanguage == Language.ENG) {
            System.out.println("Student Name: " + myStudent.getUsername());
            System.out.println("Faculty: " + myStudent.getFaculty());
            System.out.println("Total Credits: " + totalCredits);
            System.out.println("GPA: " + String.format("%.2f", gpa));
        } else if (currentLanguage == Language.RU) {
            System.out.println("Имя студента: " + myStudent.getUsername());
            System.out.println("Факультет: " + myStudent.getFaculty());
            System.out.println("Общее количество кредитов: " + totalCredits);
            System.out.println("Средний балл (GPA): " + String.format("%.2f", gpa));
        } else if (currentLanguage == Language.KZ) {
            System.out.println("Студенттің аты: " + myStudent.getUsername());
            System.out.println("Факультет: " + myStudent.getFaculty());
            System.out.println("Жалпы кредит саны: " + totalCredits);
            System.out.println("GPA: " + String.format("%.2f", gpa));
        }

        // После отображения транскрипта возвращение в меню
        menu(myStudent);
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
                boolean success = courseController.pickCourse(myStudent, pickedCourse);
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
                        System.out.println("Registration failed. Either the course exceeds the credit limit or you have already completed it.");
                    } else if (currentLanguage == Language.RU) {
                        System.out.println("Регистрация не удалась. Курс превышает лимит кредитов или вы уже прошли его.");
                    } else if (currentLanguage == Language.KZ) {
                        System.out.println("Тіркелу сәтсіз аяқталды. Курс кредит лимитінен асады немесе сіз оны бұрыннан өткенсіз.");
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
                menu(myStudent); // Возвращение в меню
                return;
            }
        } else {
            if (currentLanguage == Language.ENG) {
                System.out.println("Registration is currently closed.");
            } else if (currentLanguage == Language.RU) {
                System.out.println("Регистрация в данный момент закрыта.");
            } else if (currentLanguage == Language.KZ) {
                System.out.println("Қазіргі уақытта тіркелу жабық.");
            }
            menu(myStudent); // Возвращение в меню
        }
    }


}