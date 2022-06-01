package dao;

import entity.EnterHistory;
import entity.Scanner;

import java.util.List;

public interface EnterHistoryDAO {

    void addActivity(EnterHistory enterHistory, Long personId, Scanner scanner);

    List<EnterHistory> getLastTwentyRows();
}
