package controller;

import entity.User;
import io.javalin.http.Context;
import service.UserService;


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
            context.json(user);
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
