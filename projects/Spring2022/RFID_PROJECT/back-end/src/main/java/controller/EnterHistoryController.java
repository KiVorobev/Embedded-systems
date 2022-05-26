package controller;

import entity.EnterHistory;
import io.javalin.http.Context;
import model.EnterHistoryModel;
import model.UserModel;
import service.EnterHistoryService;

import java.util.List;
import java.util.stream.Collectors;

public class EnterHistoryController {

    private static EnterHistoryService enterHistoryService = new EnterHistoryService();

    public static void getAllLastActivities(Context context) {
        List<EnterHistory> activitiesList = enterHistoryService.getAllLastActivities();
        List<EnterHistoryModel> activitiesModelList = activitiesList.stream()
                .map(EnterHistoryModel::toModel)
                .collect(Collectors.toList());
        context.json(activitiesModelList);
    }


}
