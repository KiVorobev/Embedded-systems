package entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mcu")
@Data
@NoArgsConstructor
public class MCU {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;

}
