package Controller;

import uniUtil.*;
import data.*;
import java.util.*;
import java.time.LocalDateTime;
import Enum.*;
import Model.*;
import View.*;

public class NewsController {
    public static void acceptNewsRequest(Request request){
        News news = new News(request.getTitle(), LocalDateTime.now(),  request.getTopic(), request.getLevelImportance());
        Database.NewsDB.add(news);
        Database.saveNewsDB();
    }

    public static void rejectNewsRequest(Request request){
        for(Request r: Database.NewsRequest){
            if(r.getTitle().equals(request.getTitle())){
                Database.NewsRequest.remove(r);
                Database.saveNewsDB();
                return;
            }
        }
    }

    public static void viewNews(Language currentLanguage, User user, UserType userType) {
        User myUser = user;
        List<News> newsList = Database.getNewsDB();
        if (newsList.isEmpty()) {
            System.out.println(currentLanguage == Language.ENG
                    ? "No news available."
                    : currentLanguage == Language.RU
                    ? "Нет доступных новостей."
                    : "Қолжетімді жаңалықтар жоқ.");
            // Возвращаемся в меню
            switch (userType) {
                case STUDENT:
                    ViewStudent.menu((Student) user);
                    break;
                case TEACHER:
                    ViewTeacher.menu((Teacher) user);
                    break;
                case MANAGER:
                    ViewManager.menu((Manager) user);
                    break;
                case LIBRARIAN:
                    ViewLibrarian.menu((Librarian) user);
                    break;
                case DEAN:
                    ViewDean.menu((Dean) user);
                    break;
                default:
                    System.out.println("Invalid user type.");
                    break;
            }
            return;
        }

        Scanner scan = new Scanner(System.in);
        int currentIndex = 0;

        while (true) {
            News currentNews = newsList.get(currentIndex);
            System.out.println("\n" + (currentLanguage == Language.ENG
                    ? "Title: "
                    : currentLanguage == Language.RU
                    ? "Заголовок: "
                    : "Тақырып: ") + currentNews.getTitle());
            System.out.println((currentLanguage == Language.ENG
                    ? "Date: "
                    : currentLanguage == Language.RU
                    ? "Дата: "
                    : "Күні: ") + currentNews.getDate());
            System.out.println((currentLanguage == Language.ENG
                    ? "Content: "
                    : currentLanguage == Language.RU
                    ? "Содержание: "
                    : "Мазмұны: ") + currentNews.getTopic());
            System.out.println((currentLanguage == Language.ENG
                    ? "Importance Level: "
                    : currentLanguage == Language.RU
                    ? "Уровень важности: "
                    : "Маңыздылық деңгейі: ") + currentNews.getLevelImportance());

            System.out.println("\n" + (currentLanguage == Language.ENG
                    ? "Options:"
                    : currentLanguage == Language.RU
                    ? "Опции:"
                    : "Опциялар:"));
            System.out.println("1. " + (currentLanguage == Language.ENG
                    ? "Previous"
                    : currentLanguage == Language.RU
                    ? "Предыдущая"
                    : "Алдыңғы"));
            System.out.println("2. " + (currentLanguage == Language.ENG
                    ? "Next"
                    : currentLanguage == Language.RU
                    ? "Следующая"
                    : "Келесі"));
            System.out.println("3. " + (currentLanguage == Language.ENG
                    ? "Exit to Menu"
                    : currentLanguage == Language.RU
                    ? "Выйти в меню"
                    : "Мәзірге шығу"));

            int choice = scan.nextInt();

            if (choice == 1) {
                if (currentIndex > 0) {
                    currentIndex--;
                } else {
                    System.out.println(currentLanguage == Language.ENG
                            ? "This is the first news."
                            : currentLanguage == Language.RU
                            ? "Это первая новость."
                            : "Бұл бірінші жаңалық.");
                }
            } else if (choice == 2) {
                if (currentIndex < newsList.size() - 1) {
                    currentIndex++;
                } else {
                    System.out.println(currentLanguage == Language.ENG
                            ? "This is the last news."
                            : currentLanguage == Language.RU
                            ? "Это последняя новость."
                            : "Бұл соңғы жаңалық.");
                }
            } else if (choice == 3) {
                System.out.println(currentLanguage == Language.ENG
                        ? "Returning to the menu..."
                        : currentLanguage == Language.RU
                        ? "Возврат в меню..."
                        : "Мәзірге оралу...");
                switch (userType){
                    case STUDENT:
                        ViewStudent.menu((Student) user);
                        break;
                    case TEACHER:
                        ViewTeacher.menu((Teacher) user);
                        break;
                    case MANAGER:
                        ViewManager.menu((Manager) user);
                        break;
                    case LIBRARIAN:
                        ViewLibrarian.menu((Librarian) user);
                        break;
                    case DEAN:
                        ViewDean.menu((Dean) user);
                        break;
                    default:
                        System.out.println("Invalid user type.");
                        break;
                }// Вызываем метод меню
                return;
            } else {
                System.out.println(currentLanguage == Language.ENG
                        ? "Invalid option. Try again."
                        : currentLanguage == Language.RU
                        ? "Неверный вариант. Попробуйте еще раз."
                        : "Қате нұсқа. Қайта көріңіз.");
            }
        }
    }

}
