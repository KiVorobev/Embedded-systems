package dao;

import entity.EnterHistory;
import entity.Scanner;

public interface EnterHistoryDAO {

    void addActivity(EnterHistory enterHistory, Long personId, Scanner scanner);
}
