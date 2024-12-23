package Controller;

import Enum.*;
import Model.*;
import data.Database;
import java.util.*;

public class UserController {

    // Метод для создания нового пользователя
    public static boolean createUser(
            String username,
            String password,
            UserType type,
            Faculty faculty,
            Degree degree) {
        switch (type) {
            case TEACHER:
                Teacher newTeacher = new Teacher(username, password, faculty, degree);
                Database.TeacherDB.add(newTeacher);
                return Database.saveTeachers();
            case STUDENT:
                Scanner sc = new Scanner(System.in);
                System.out.println("year / год / жыл");
                int num = sc.nextInt(); // exception year
                Student newStudent = new Student(username, password, faculty, num);
                Database.StudentDB.add(newStudent);
                return Database.saveStudents();
            case MANAGER:
                Manager newManager = new Manager(username, password);
                Database.ManagerDB.add(newManager);
                return Database.saveManagers();
            case LIBRARIAN:
                Librarian newLibrarian = new Librarian(username, password);
                Database.LibrarianDB.add(newLibrarian);
                return Database.saveLibrarians();
            case DEAN:
                Dean newDean = new Dean(username, password);
                Database.DeanDB.add(newDean);
                return Database.saveDeans();
            default:
                return false;
        }
    }

    // Метод для получения списка пользователей по типу
    public static Object getUsers(UserType type) {
        switch (type) {
            case TEACHER:
                return Database.TeacherDB;
            case STUDENT:
                return Database.StudentDB;
            case MANAGER:
                return Database.ManagerDB;
            case LIBRARIAN:
                return Database.LibrarianDB;
            case DEAN:
                return Database.DeanDB;
            default:
                return null;
        }
    }

    public static User getUser(UserType type, String username){
        switch (type) {
            case TEACHER:
                 for(Teacher teacher : Database.TeacherDB){
                     if(teacher.getUsername().equals(username)){
                         return (User)teacher;
                     }
                 }
            case STUDENT:
                for(Student student : Database.StudentDB){
                    if(student.getUsername().equals(username)){
                        return (User)student;
                    }
                }
            case MANAGER:
                for(Manager manager : Database.ManagerDB){
                    if(manager.getUsername().equals(username)){
                        return (User)manager;
                    }
                }
            case LIBRARIAN:
                for(Librarian librarian : Database.LibrarianDB){
                    if(librarian.getUsername().equals(username)){
                        return (User)librarian;
                    }
                }
            case DEAN:
                for(Dean dean : Database.DeanDB){
                    if(dean.getUsername().equals(username)){
                        return (User)dean;
                    }
                }
            default:
                return null;
        }
    }

    // Метод для авторизации пользователя
    public static boolean authorize(String fileName, String username, String password) {
        switch (fileName) {
            case "teacher.txt":
                for (Teacher t : Database.TeacherDB) {
                    if (t.getUsername().equals(username) && t.getPassword().equals(password))
                        return true;
                }
                break;
            case "student.txt":
                for (Student s : Database.StudentDB) {
                    if (s.getUsername().equals(username) && s.getPassword().equals(password))
                        return true;
                }
                break;
            case "manager.txt":
                for (Manager m : Database.ManagerDB) {
                    if (m.getUsername().equals(username) && m.getPassword().equals(password))
                        return true;
                }
                break;
            case "librarian.txt":
                for (Librarian l : Database.LibrarianDB) {
                    if (l.getUsername().equals(username) && l.getPassword().equals(password))
                        return true;
                }
                break;
            case "dean.txt":
                for (Dean d : Database.DeanDB) {
                    if (d.getUsername().equals(username) && d.getPassword().equals(password))
                        return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

    // Метод для удаления пользователя
    public static boolean deleteUser(String username, UserType type) {
        switch (type) {
            case TEACHER:
                for (Teacher t : Database.TeacherDB) {
                    if (t.getUsername().equals(username)) {
                        Database.TeacherDB.remove(t);
                        return Database.saveTeachers(); // Сохраняем обновленный список учителей
                    }
                }
                break;
            case STUDENT:
                for (Student s : Database.StudentDB) {
                    if (s.getUsername().equals(username)) {
                        Database.StudentDB.remove(s);
                        return Database.saveStudents(); // Сохраняем обновленный список студентов
                    }
                }
                break;
            case MANAGER:
                for (Manager m : Database.ManagerDB) {
                    if (m.getUsername().equals(username)) {
                        Database.ManagerDB.remove(m);
                        return Database.saveManagers(); // Сохраняем обновленный список менеджеров
                    }
                }
                break;
            case LIBRARIAN:
                for (Librarian l : Database.LibrarianDB) {
                    if (l.getUsername().equals(username)) {
                        Database.LibrarianDB.remove(l);
                        return Database.saveLibrarians(); // Сохраняем обновленный список библиотекарей
                    }
                }
                break;
            case DEAN:
                for (Dean d : Database.DeanDB) {
                    if (d.getUsername().equals(username)) {
                        Database.DeanDB.remove(d);
                        return Database.saveDeans(); // Сохраняем обновленный список деканов
                    }
                }
                break;
            default:
                return false;
        }
        return false; // Если пользователь не найден
    }
}