package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "scanners")
@Data
@NoArgsConstructor
public class Scanner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hardware_number", unique = true, nullable = false)
    private String hardwareNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnoreProperties("scanner")
    @OneToMany(mappedBy = "scanner", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private List<EnterHistory> activities;
}
