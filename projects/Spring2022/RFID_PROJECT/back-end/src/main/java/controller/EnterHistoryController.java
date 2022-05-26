package controller;

import entity.EnterHistory;
import io.javalin.http.Context;
import model.EnterHistoryModel;
import model.UserModel;
import service.EnterHistoryService;
import util.ViewUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.javalin.plugin.rendering.template.TemplateUtil.model;

public class EnterHistoryController {

    private static EnterHistoryService enterHistoryService = new EnterHistoryService();

    public static void getAllLastActivities(Context context) {
        List<EnterHistory> activitiesList = enterHistoryService.getAllLastActivities();
        List<EnterHistoryModel> activitiesModelList = activitiesList.stream()
                .map(EnterHistoryModel::toModel)
                .collect(Collectors.toList());
        Map<String, Object> model = ViewUtil.getBaseModel();
        model.put("activities", activitiesModelList);
        context.render("start_page.ftl", model);
    }


}
