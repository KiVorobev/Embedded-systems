package controller;

import entity.DismissedEnterHistory;
import io.javalin.http.Context;
import model.DismissedEnterHistoryModel;
import service.DismissedEnterHistoryService;
import util.ViewUtil;

import java.util.List;
import java.util.Map;

public class DismissedEnterHistoryController {

    private static DismissedEnterHistoryService dismissedEnterHistoryService = new DismissedEnterHistoryService();


    public static void renderAllLastActivityPage(Context context) {
        List<DismissedEnterHistory> dismissedEnterHistoryList = dismissedEnterHistoryService.getLastDismissedActivities();
        List<DismissedEnterHistoryModel> dismissedEnterHistoryModelList = DismissedEnterHistoryModel.fromEntityListToModelList(dismissedEnterHistoryList);
        Map<String, Object> model = ViewUtil.getBaseModel();
        model.put("activities", dismissedEnterHistoryModelList);
        context.render("templates/rejected_requests.ftl", model);
    }
}
