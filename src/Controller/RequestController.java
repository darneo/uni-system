package Controller;

import Model.*;
import uniUtil.*;
import data.Database;

public class RequestController {

    // Метод для принятия запроса и добавления его в базу данных
    public static void acceptRequest(Request request) {
        Database.EmployeeRequestDB.add(request);
        Database.saveEmployeeRequests();
    }

    // Метод для подписания запроса, удаления его из списка запросов и перемещения в подписанные запросы
    public static void signRequest(Request request) {
        if (Database.EmployeeRequestDB.contains(request)) {
            Database.EmployeeRequestDB.remove(request);
            Database.AcceptedEmployeeRequests.add(request);
            Database.saveEmployeeRequests();
            Database.saveAcceptedEmployeeRequests();
        }
    }

    // Метод для добавления отчета (Report) в базу данных
    public static void addReport(Report report) {
        // Добавляем отчет в базу данных отчетов
        Database.ReportDB.add(report);

        // Сохраняем изменения
        Database.saveReports(); // Метод для сохранения отчетов в базу данных
    }
}
