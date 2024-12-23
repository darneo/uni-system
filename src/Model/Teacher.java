package Model;

import Enum.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;
import uniUtil.*;
import java.util.List;
import java.util.ArrayList;

public class Teacher extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private Degree degree;  // Степень как перечисление
    private double rate = 0;
    private HashMap<Lesson, Vector<Student>> listOfStudents;
    private Faculty faculty; // факультет как перечисление

    // Добавляем поле для хранения запросов
    private List<Request> requests;

    // Конструктор, принимающий все параметры
    public Teacher(String username, String password, Faculty faculty, Degree degree) {
        super(username, password); // передаем только username и password в родительский класс
        this.degree = degree;
        this.faculty = faculty;
        this.requests = new ArrayList<>(); // Инициализация списка запросов
    }

    // Метод toString для конвертации degree и faculty в строку
    @Override
    public String toString() {
        return super.toString()  +
                "degree='" + degree.toString() + '\'' +  // Преобразуем degree в строку
                ", rate=" + rate +
                ", faculty='" + faculty.toString() + '\'' + // Преобразуем faculty в строку
                '}';
    }

    // Геттеры для факультета и других полей (если необходимо)
    public String getName() {
        return super.getUsername();
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Degree getDegree() {
        return degree;
    }

    public double getRate() {
        return rate;
    }

    public HashMap<Lesson, Vector<Student>> getListOfStudents() {
        return listOfStudents;
    }

    // Геттер для списка запросов
    public List<Request> getRequests() {
        return requests;
    }

    // Метод для добавления запроса
    public void addRequest(Request request) {
        this.requests.add(request);
    }
}
