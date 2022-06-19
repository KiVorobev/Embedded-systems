package dao;

import entity.DismissedEnterHistory;
import entity.Scanner;

import java.util.List;

public interface DismissedEnterHistoryDAO {

    void addDismissedActivity(Scanner scanner, String cardId);

    List<DismissedEnterHistory> getLastTwentyRows();
}
