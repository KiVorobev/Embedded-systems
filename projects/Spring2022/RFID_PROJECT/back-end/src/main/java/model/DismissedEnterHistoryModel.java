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
    private String formattedDismissedEnterActivity;
    private Scanner scanner;
    private String cardId;

    public static DismissedEnterHistoryModel toModel(DismissedEnterHistory dismissedEnterHistory) {
        DismissedEnterHistoryModel dismissedEnterHistoryModel = new DismissedEnterHistoryModel();
        dismissedEnterHistoryModel.setDismissedEnterActivity(dismissedEnterHistory.getEnterActivity());
        dismissedEnterHistoryModel.setScanner(dismissedEnterHistory.getScanner());
        dismissedEnterHistoryModel.setScannerHardwareNum(dismissedEnterHistory.getScanner().getHardwareNumber());
        dismissedEnterHistoryModel.setFormattedDismissedEnterActivity(TimeFormatter.formatToString(dismissedEnterHistory));
        dismissedEnterHistoryModel.setCardId(dismissedEnterHistory.getCardId());
        return dismissedEnterHistoryModel;
    }

    public static List<DismissedEnterHistoryModel> fromEntityListToModelList(List<DismissedEnterHistory> entityList) {
        return entityList.stream()
                .map(DismissedEnterHistoryModel::toModel)
                .collect(Collectors.toList());
    }

}
