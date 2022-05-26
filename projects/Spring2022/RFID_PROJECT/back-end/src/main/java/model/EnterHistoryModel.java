package model;

import entity.EnterHistory;
import entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnterHistoryModel {

    private Long scannerId;
    private LocalDateTime enterActivity;
    private UserModel user;

    public static EnterHistoryModel toModel(EnterHistory enterHistory) {
        EnterHistoryModel enterHistoryModel = new EnterHistoryModel();
        enterHistoryModel.setUser(UserModel.toModel(enterHistory.getUser()));
        enterHistoryModel.setScannerId(enterHistory.getScanner().getInnerId());
        enterHistoryModel.setEnterActivity(enterHistory.getEnterActivity());
        return enterHistoryModel;
    }
}
