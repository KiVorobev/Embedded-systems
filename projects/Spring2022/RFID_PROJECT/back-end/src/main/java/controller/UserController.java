package controller;

import entity.User;
import io.javalin.http.Context;
import model.EnterHistoryModel;
import model.UserModel;
import service.UserService;
import util.ViewUtil;

import java.util.List;
import java.util.Map;


public class UserController {

    private static final UserService userService = new UserService();

    public static void addUser(Context context) {
        try {
            User user = context.bodyAsClass(User.class);
            userService.add(user);
            context.header("userId", user.getId().toString());
            context.json(user);

        } catch (Exception e) {
            context.result("Номер карты один для каждого пользователя!");
        }
    }

    public static void getUser(Context context) {
        User user = userService.getById(Long.parseLong(context.pathParam("id")));
        if (user == null) {
            context.status(404);
            return;
        }
        UserModel userModel = UserModel.toModel(user);
        List<EnterHistoryModel> enterHistoryModel = EnterHistoryModel.fromEntityListToModelList(userModel.getEnterHistory());
        Map<String, Object> model = ViewUtil.getBaseModel();
        model.put("user", userModel);
        model.put("activities", enterHistoryModel);
        context.render("views/pages/user_page.ftl", model);
    }

    public static void getUserByCardId(Context context) {
        String cardId = context.formParam("cardId");
        User user = userService.getByCardId(cardId);
        if (user == null) {
            context.status(404);
            return;
        }
        UserModel userModel = UserModel.toModel(user);
        context.header("userId", userModel.getUserId().toString());
        context.status(200);
    }


    public static void editUser(Context context) {
        try {
            User user = userService.getById(Long.parseLong(context.pathParam("id")));
            UserModel userModel = UserModel.toModel(user);
            Map<String, Object> model = ViewUtil.getBaseModel();
            model.put("user", userModel);
            model.put("activities", userModel.getEnterHistory());
            context.render("views/pages/user_edit.ftl", model);
        } catch (Exception e) {
            context.result(e.getMessage());
        }
    }

    public static void deleteUser(Context context) {
        Long id = Long.parseLong(context.pathParam("id"));
        userService.deleteUser(id);
        context.result("Deleted");
    }

    public static void updateUser(Context context) {
        try {
            User user = context.bodyAsClass(User.class);
            UserModel userModel = UserModel.toModel(user);
            userService.updateUser(user.getId(), user);
            context.status(200);
            context.json(user);
        } catch (Exception e) {
            context.result(e.getMessage());
        }
    }

    public static void renderAddUserPage(Context context) {
        Map<String, Object> model = ViewUtil.getBaseModel();
        context.render("views/pages/add_user.ftl", model);
    }

    public static void renderSearchUserPage(Context context) {
        Map<String, Object> model = ViewUtil.getBaseModel();
        context.render("views/pages/search.ftl", model);
    }
}
