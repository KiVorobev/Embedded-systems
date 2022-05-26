package controller;

import entity.User;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import model.UserModel;
import service.UserService;

import static io.javalin.plugin.rendering.template.TemplateUtil.model;


public class UserController {

    private static final UserService userService = new UserService();

    public static void addUser(Context context) {
        User user = context.bodyAsClass(User.class);
        userService.add(user);
        context.json(user);
    }

    public static void getUser(Context context) {
        try {
            User user = userService.getById(Long.parseLong(context.pathParam("id")));
            UserModel userModel = UserModel.toModel(user);
            context.render("test.ftl", model("name", userModel.getName(), "surname", userModel.getSurname(), "patronymic",
                    userModel.getPatronymic(), "role", userModel.getRole()));
//            context.json(user);
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
        User user = context.bodyAsClass(User.class);
        userService.updateUser(user.getId(), user);
        context.json(user);
    }


}
