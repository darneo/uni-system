package data;

import Model.*;
import uniUtil.*;

import java.io.*;
import java.util.*;

public class Database implements Serializable {
    public static String adminWord = "daryn";
    public static String adminPassword = "daryn";
    public static final long serialVersionUID = 1L; // UID для сериализации

    public static Vector<News> NewsDB;
    public static HashMap<Journal, Vector<User>> JournalDB;
    public static Vector<Course> Courses;
    public static Boolean isOpenRegistration = false;
    public static Vector<Manager> ManagerDB;
    public static Vector<Teacher> TeacherDB;
    public static Vector<Student> StudentDB;
    public static Vector<Report> Reports;
    public static HashMap<Book, Integer> CountOfbooks;
    public static HashMap<Student, Vector<Book>> ListOFstudents;
    public static Vector<Dean> DeanDB;
    public static Vector<Librarian> LibrarianDB;
    public static Vector<Request> EmployeeRequestDB;
    public static Vector<Request> AcceptedEmployeeRequests;

    private static final String path = "C:\\Users\\Admin\\IdeaProjects\\wsp-system\\src\\data\\files\\";

    private static final String coursePath = "course.txt";
    private static final String journalPath = "journal.txt";
    private static final String newsPath = "news.txt";
    private static final String reportPath = "report.txt";
    private static final String studentPath = "student.txt";
    private static final String teacherPath = "teacher.txt";
    private static final String ManagerPath = "Request.txt";
    private static final String CountOfBooksPath = "CountOfBooks.txt";
    private static final String ListOFstudentsPath = "ListOfStudents.txt";
    private static final String ListOfDeanPath = "ListOfDeans.txt";
    private static final String LibrarianPath = "ListOfLibrarians.txt";
    private static final String EmployeeRequestPath = "EmployeeRequest.txt";
    private static final String AcceptedEmployeeRequestsPath = "AcceptedRequests.txt"; // Путь для сохранения принятых запросов

    static {
        TeacherDB = getTeachers();
        StudentDB = getStudents();
        ManagerDB = getManagers();
        Reports = getReports();
        Courses = getCourse();
        JournalDB = getSubscribers();
        NewsDB = getNewsDB();
        CountOfbooks = getCountOfbooks();
        ListOFstudents = getListOfStudents();
        DeanDB = getDeans();
        LibrarianDB = getLibrarians();

        // Инициализация векторов запросов
        EmployeeRequestDB = getEmployeeRequests();
        AcceptedEmployeeRequests = getAcceptedEmployeeRequests();
    }

    public Database() {
    }

    // Методы для работы с запросами сотрудников
    public static Vector<Request> getEmployeeRequests() {
        Object o = ReaderWriter.deserialize(path + EmployeeRequestPath);
        if (o instanceof Vector) {
            return (Vector<Request>) o;
        }
        return new Vector<>();
    }

    public static boolean saveEmployeeRequests() {
        return ReaderWriter.serialize(EmployeeRequestDB, path + EmployeeRequestPath);
    }


    // Методы для работы с принятыми запросами
    public static Vector<Request> getAcceptedEmployeeRequests() {
        Object o = ReaderWriter.deserialize(path + AcceptedEmployeeRequestsPath);
        if (o instanceof Vector) {
            return (Vector<Request>) o;
        }
        return new Vector<>();
    }

    public static boolean saveAcceptedEmployeeRequests() {
        return ReaderWriter.serialize(AcceptedEmployeeRequests, path + AcceptedEmployeeRequestsPath);
    }


    // Остальные методы для работы с базой данных

    public static Vector<Teacher> getTeachers() {
        Object o = ReaderWriter.deserialize(path + teacherPath);
        if (o instanceof Vector) {
            return (Vector<Teacher>) o;
        }
        return new Vector<>();
    }

    public static boolean saveTeachers() {
        return ReaderWriter.serialize(TeacherDB, path + teacherPath);
    }

    public static Vector<Student> getStudents() {
        Object o = ReaderWriter.deserialize(path + studentPath);
        if (o instanceof Vector) {
            return (Vector<Student>) o;
        }
        return new Vector<>();
    }

    public static boolean saveStudents() {
        return ReaderWriter.serialize(StudentDB, path + studentPath);
    }

    public static Vector<Manager> getManagers() {
        Object o = ReaderWriter.deserialize(path + ManagerPath);
        if (o instanceof Vector) {
            return (Vector<Manager>) o;
        }
        return new Vector<>();
    }

    public static Boolean saveManagers() {
        return ReaderWriter.serialize(ManagerDB, path + ManagerPath);
    }

    public static Vector<Report> getReports() {
        Object o = ReaderWriter.deserialize(path + reportPath);
        if (o instanceof Vector) {
            return (Vector<Report>) o;
        }
        return new Vector<>();
    }

    public static Boolean saveReports() {
        return ReaderWriter.serialize(Reports, path + reportPath);
    }

    public static Vector<Course> getCourse() {
        Object o = ReaderWriter.deserialize(path + coursePath);
        if (o instanceof Vector) {
            return (Vector<Course>) o;
        }
        return new Vector<>();
    }

    public static Boolean saveCourse() {
        return ReaderWriter.serialize(Courses, path + coursePath);
    }

    public static HashMap<Journal, Vector<User>> getSubscribers() {
        Object o = ReaderWriter.deserialize(path + journalPath);
        if (o instanceof HashMap) {
            return (HashMap<Journal, Vector<User>>) o;
        }
        return new HashMap<>();
    }

    public static Boolean saveSubscribers() {
        return ReaderWriter.serialize(JournalDB, path + journalPath);
    }

    public static Vector<News> getNewsDB() {
        Object o = ReaderWriter.deserialize(path + newsPath);
        if (o instanceof Vector) {
            return (Vector<News>) o;
        }
        return new Vector<>();
    }

    public static Boolean saveNewsDB() {
        return ReaderWriter.serialize(NewsDB, path + newsPath);
    }

    public static HashMap<Book, Integer> getCountOfbooks() {
        Object o = ReaderWriter.deserialize(path + CountOfBooksPath);
        if (o instanceof Vector) {
            return (HashMap<Book, Integer>) o;
        }
        return new HashMap<>();
    }

    public static Boolean saveCountOfbooks() {
        return ReaderWriter.serialize(CountOfbooks, path + CountOfBooksPath);
    }

    public static HashMap<Student, Vector<Book>> getListOfStudents() {
        Object o = ReaderWriter.deserialize(path + ListOFstudentsPath);
        if (o instanceof Vector) {
            return (HashMap<Student, Vector<Book>>) o;
        }
        return new HashMap<>();
    }

    public static Boolean saveListOfStudents() {
        return ReaderWriter.serialize(ListOFstudents, path + ListOFstudentsPath);
    }

    public static Vector<Dean> getDeans() {
        Object o = ReaderWriter.deserialize(path + ListOfDeanPath);
        if (o instanceof Vector) {
            return (Vector<Dean>) o;
        }
        return new Vector<>();
    }

    public static Boolean saveDeans() {
        return ReaderWriter.serialize(DeanDB, path + ListOfDeanPath);
    }

    public static Vector<Librarian> getLibrarians() {
        Object o = ReaderWriter.deserialize(path + LibrarianPath);
        if (o instanceof Vector) {
            return (Vector<Librarian>) o;
        }
        return new Vector<>();
    }

    public static Boolean saveLibrarians() {
        return ReaderWriter.serialize(LibrarianDB, path + LibrarianPath);
    }

    public static void saveAll() {
        saveTeachers();
        saveStudents();
        saveManagers();
        saveReports();
        saveCourse();
        saveSubscribers();
        saveNewsDB();
        saveCountOfbooks();
        saveListOfStudents();
        saveDeans();
        saveLibrarians();
        saveEmployeeRequests();  // Сохраняем все запросы сотрудников
        saveAcceptedEmployeeRequests();  // Сохраняем принятые запросы сотрудников
    }
    public static void initializeDatabase() {
        NewsDB = new Vector<>();
        JournalDB = new HashMap<>();
        Courses = new Vector<>();
        isOpenRegistration = false;
        ManagerDB = new Vector<>();
        TeacherDB = new Vector<>();
        StudentDB = new Vector<>();
        Reports = new Vector<>();
        CountOfbooks = new HashMap<>();
        ListOFstudents = new HashMap<>();
        DeanDB = new Vector<>();
        LibrarianDB = new Vector<>();
        EmployeeRequestDB = new Vector<>();
        AcceptedEmployeeRequests = new Vector<>();
    }

}
