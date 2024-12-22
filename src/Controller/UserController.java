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
                Manager newManager = new Manager(username, password, faculty);
                Database.ManagerDB.add(newManager);
                return Database.saveManagers();
            case LIBRARIAN:
                Librarian newLibrarian = new Librarian(username, password);
                Database.LibrarianDB.add(newLibrarian);
                return Database.saveLibrarians();
            case DEAN:
                Dean newDean = new Dean(username, password, faculty);
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
                return Database.getTeachers();
            case STUDENT:
                return Database.getStudents();
            case MANAGER:
                return Database.getManagers();
            case LIBRARIAN:
                return Database.getLibrarians();
            case DEAN:
                return Database.getDeans();
            default:
                return null;
        }
    }

    // Метод для авторизации пользователя
    public static boolean authorize(String fileName, String username, String password) {
        if (fileName.equals("teacher.txt")) {
            Vector<Teacher> teachers = (Vector<Teacher>) getUsers(UserType.TEACHER);
            for (Teacher t : teachers) {
                if (t.getUsername().equals(username) && t.getPassword().equals(password))
                    return true;
            }
        }
        if (fileName.equals("student.txt")) {
            Vector<Student> students = (Vector<Student>) getUsers(UserType.STUDENT);
            for (Student s : students) {
                if (s.getUsername().equals(username) && s.getPassword().equals(password))
                    return true;
            }
        }
        if (fileName.equals("manager.txt")) {
            Vector<Manager> managers = (Vector<Manager>) getUsers(UserType.MANAGER);
            for (Manager m : managers) {
                if (m.getUsername().equals(username) && m.getPassword().equals(password))
                    return true;
            }
        }
        if (fileName.equals("librarian.txt")) {
            Vector<Librarian> librarians = (Vector<Librarian>) getUsers(UserType.LIBRARIAN);
            for (Librarian l : librarians) {
                if (l.getUsername().equals(username) && l.getPassword().equals(password))
                    return true;
            }
        }
        if (fileName.equals("dean.txt")) {
            Vector<Dean> deans = (Vector<Dean>) getUsers(UserType.DEAN);
            for (Dean d : deans) {
                if (d.getUsername().equals(username) && d.getPassword().equals(password))
                    return true;
            }
        }

        return false;
    }
}
