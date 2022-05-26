package model;

import entity.User;
import enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private String name;
    private String surname;
    private String patronymic;
    private Role role;

    public static UserModel toModel(User user) {
        UserModel userModel = new UserModel();
        userModel.setName(user.getName());
        userModel.setSurname(user.getSurname());
        userModel.setPatronymic(user.getPatronymic());
        userModel.setRole(user.getRole());
        return userModel;
    }
}
