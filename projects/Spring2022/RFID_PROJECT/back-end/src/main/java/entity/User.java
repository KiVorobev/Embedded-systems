package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "card_id", unique = true)
    private String cardId;

    @ToString.Exclude
    @JsonIgnoreProperties("user")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private List<EnterHistory> enterHistory;

}
