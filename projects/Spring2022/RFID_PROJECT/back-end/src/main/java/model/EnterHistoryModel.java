package model;

import entity.EnterHistory;
import entity.Scanner;
import entity.User;
import lombok.*;
import util.TimeFormatter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class EnterHistoryModel {

    private String scannerHardwareNum;
    private LocalDateTime enterActivity;
    private UserModel user;
    private String formattedEnterActivity;
    private Scanner scanner;

    public static EnterHistoryModel toModel(EnterHistory enterHistory) {
        EnterHistoryModel enterHistoryModel = new EnterHistoryModel();
        enterHistoryModel.setUser(UserModel.toModel(enterHistory.getUser()));
        enterHistoryModel.setScannerHardwareNum(enterHistory.getScanner().getHardwareNumber());
        enterHistoryModel.setEnterActivity(enterHistory.getEnterActivity());
        enterHistoryModel.setFormattedEnterActivity(TimeFormatter.formatToString(enterHistory));
        enterHistoryModel.setScanner(enterHistory.getScanner());
        return enterHistoryModel;
    }

    public static List<EnterHistoryModel> fromEntityListToModelList(List<EnterHistory> entityList) {
        return entityList.stream()
                .map(EnterHistoryModel::toModel)
                .collect(Collectors.toList());
    }
}
