package service;

import dao.EnterHistoryDAO;
import dao.EntityHistoryDAOImpl;
import entity.EnterHistory;

import java.util.List;

public class EnterHistoryService {

    private EnterHistoryDAO enterHistoryDAO;

    public EnterHistoryService() {
        enterHistoryDAO = new EntityHistoryDAOImpl();
    }

    public List<EnterHistory> getAllLastActivities() {
        return enterHistoryDAO.getLastTenRows();
    }

}
