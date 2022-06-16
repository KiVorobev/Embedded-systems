package dao;

import entity.EnterHistory;
import entity.Scanner;

import java.util.List;

public interface EnterHistoryDAO {

    void addActivity(Long personId, Scanner scanner);

    List<EnterHistory> getLastTwentyRows();

    void deleteActivityList(Long id);
}
