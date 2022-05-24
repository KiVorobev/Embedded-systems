package dao;

import entity.EnterHistory;

public interface EnterHistoryDAO {

    void addActivity(EnterHistory enterHistory, Long personId);
}
