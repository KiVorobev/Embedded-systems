package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "enter_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnterHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime enterActivity;

    @JsonIgnoreProperties("enterHistory")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "scanner_id")
    private Scanner scanner;

    public EnterHistory(LocalDateTime enterActivity) {
        this.enterActivity = enterActivity;
    }
}
