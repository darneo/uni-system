package Model;

import uniUtil.*;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Librarian extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    // Добавляем поле для хранения запросов
    private List<Request> requests;

    // Конструктор
    public Librarian(String mail, String password) {
        super(mail, password); // передаем только username и password в родительский класс
        this.requests = new ArrayList<>(); // Инициализация списка запросов
    }

    // Геттер для списка запросов
    public List<Request> getRequests() {
        return requests;
    }

    // Метод для добавления запроса
    public void addRequest(Request request) {
        this.requests.add(request);
    }

    // Метод toString, если нужно для отладки
    @Override
    public String toString() {
        return super.toString() + " Requests: " + requests.size();
    }
}
