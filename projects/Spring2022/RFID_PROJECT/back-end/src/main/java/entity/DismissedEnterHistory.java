package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "dismissed_enter_history")
@Data
public class DismissedEnterHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime enterActivity;

    @Column(name = "card_id")
    private String cardId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "scanner_id")
    private Scanner scanner;

}
