package controller;

import entity.EnterHistory;
import io.javalin.http.Context;
import model.EnterHistoryModel;
import service.EnterHistoryService;
import util.ViewUtil;

import java.util.List;
import java.util.Map;


public class EnterHistoryController {

    private static EnterHistoryService enterHistoryService = new EnterHistoryService();

    public static void getAllLastActivities(Context context) {
        List<EnterHistory> activitiesList = enterHistoryService.getAllLastActivities();
        List<EnterHistoryModel> activitiesModelList = EnterHistoryModel.fromEntityListToModelList(activitiesList);
        Map<String, Object> model = ViewUtil.getBaseModel();
        model.put("activities", activitiesModelList);
        context.render("templates/main_page.ftl", model);
    }

    public static void deleteActivityList(Context context) {
        Long id = Long.parseLong(context.pathParam("id"));
        enterHistoryService.deleteActivityList(id);
    }
}
