package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "scanners")
public class Scanner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hardware_number", unique = true, nullable = false)
    private String hardwareNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ToString.Exclude
    @JsonIgnoreProperties("scanner")
    @OneToMany(mappedBy = "scanner", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private List<EnterHistory> activities;
}
