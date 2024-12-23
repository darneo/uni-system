package Controller;

import Model.*;
import Enum.*;
import uniUtil.*;
import data.Database;
import java.util.Vector;

public class RequestController {

    // Метод для принятия запроса и добавления его в базу данных
    public static void acceptRequest(Request request) {
        // Добавляем запрос в базу данных (вектор запросов)
        Database.EmployeeRequestDB.add(request);

        // Сохраняем изменения
        Database.saveEmployeeRequests();
    }

    // Метод для подписания запроса, удаления его из списка запросов и перемещения в подписанные запросы
    public static void signRequest(Request request) {
        // Проверка, что запрос существует в базе данных
        if (Database.EmployeeRequestDB.contains(request)) {
            // Удаляем запрос из вектора всех запросов
            Database.EmployeeRequestDB.remove(request);

            // Добавляем запрос в вектор подписанных запросов
            Database.AcceptedEmployeeRequests.add(request);

            // Сохраняем изменения
            Database.saveEmployeeRequests();  // Сохраняем все запросы
            Database.saveAcceptedEmployeeRequests();  // Сохраняем подписанные запросы
        }
    }
}
