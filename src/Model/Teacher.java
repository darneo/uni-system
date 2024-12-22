package Model;
import Enum.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;
import uniUtil.*;

public class Teacher extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private Degree degree;  // Степень как перечисление
    private double rate = 0;
    private HashMap<Lesson, Vector<Student>> listOfStudents;
    private Faculty faculty; // факультет как перечисление

    // Конструктор, принимающий все параметры
    public Teacher(String username, String password, Faculty faculty, Degree degree) {
        super(username, password); // передаем только username и password в родительский класс
        this.degree = degree;
        this.faculty = faculty;
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
}
