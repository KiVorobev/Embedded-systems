package dao;

import entity.DismissedEnterHistory;
import entity.Scanner;

import java.util.List;

public interface DismissedEnterHistoryDAO {

    void addDismissedActivity(Long personId, Scanner scanner);

    List<DismissedEnterHistory> getLastTwentyRows();
}
