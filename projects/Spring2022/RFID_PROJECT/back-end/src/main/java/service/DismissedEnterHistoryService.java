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

    public void addDismissedActivity(Long personId, Scanner scanner) {
        dismissedEnterHistoryDAO.addDismissedActivity(personId, scanner);
    }

}
