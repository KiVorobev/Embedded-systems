package model;

import entity.EnterHistory;
import entity.User;
import enums.Role;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserModel {

    private Long userId;
    private String name;
    private String surname;
    private String patronymic;
    private Role role;
    private List<EnterHistory> enterHistory;

    public static UserModel toModel(User user) {
        UserModel userModel = new UserModel();
        userModel.setUserId(user.getId());
        userModel.setName(user.getName());
        userModel.setSurname(user.getSurname());
        userModel.setPatronymic(user.getPatronymic());
        userModel.setRole(user.getRole());
        userModel.setEnterHistory(user.getEnterHistory());
        return userModel;
    }

}
