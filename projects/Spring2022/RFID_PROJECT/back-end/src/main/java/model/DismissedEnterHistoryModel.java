package model;

import entity.DismissedEnterHistory;
import entity.EnterHistory;
import entity.Scanner;
import lombok.Data;
import util.TimeFormatter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class DismissedEnterHistoryModel {

    private String scannerHardwareNum;
    private LocalDateTime dismissedEnterActivity;
    private UserModel user;
    private String formattedDismissedEnterActivity;
    private Scanner scanner;

    public static DismissedEnterHistoryModel toModel(DismissedEnterHistory dismissedEnterHistory) {
        DismissedEnterHistoryModel dismissedEnterHistoryModel = new DismissedEnterHistoryModel();
        dismissedEnterHistoryModel.setDismissedEnterActivity(dismissedEnterHistory.getEnterActivity());
        dismissedEnterHistoryModel.setScanner(dismissedEnterHistory.getScanner());
        dismissedEnterHistoryModel.setUser(UserModel.toModel(dismissedEnterHistory.getUser()));
        dismissedEnterHistoryModel.setScannerHardwareNum(dismissedEnterHistory.getScanner().getHardwareNumber());
        dismissedEnterHistoryModel.setFormattedDismissedEnterActivity(TimeFormatter.formatToString(dismissedEnterHistory));
        return dismissedEnterHistoryModel;
    }

    public static List<DismissedEnterHistoryModel> fromEntityListToModelList(List<DismissedEnterHistory> entityList) {
        return entityList.stream()
                .map(DismissedEnterHistoryModel::toModel)
                .collect(Collectors.toList());
    }

}
