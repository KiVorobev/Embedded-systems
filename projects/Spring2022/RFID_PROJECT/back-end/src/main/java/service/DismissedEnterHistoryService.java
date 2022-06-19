package service;

import dao.DismissedEnterHistoryDAO;
import dao.DismissedEnterHistoryDAOImpl;
import entity.DismissedEnterHistory;
import entity.Scanner;

import java.util.List;

public class DismissedEnterHistoryService {

    private DismissedEnterHistoryDAO dismissedEnterHistoryDAO;

    public DismissedEnterHistoryService() {
        dismissedEnterHistoryDAO = new DismissedEnterHistoryDAOImpl();
    }

    public List<DismissedEnterHistory> getLastDismissedActivities() {
        return dismissedEnterHistoryDAO.getLastTwentyRows();
    }

    public void addDismissedActivity(Scanner scanner, String cardId) {
        dismissedEnterHistoryDAO.addDismissedActivity(scanner, cardId);
    }

}
