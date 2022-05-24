package entity;

import enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "scanners")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Scanner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hardware_number", unique = true, nullable = false)
    private String hardwareNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "inner_id", unique = true, nullable = false)
    private Long innerId;
}
