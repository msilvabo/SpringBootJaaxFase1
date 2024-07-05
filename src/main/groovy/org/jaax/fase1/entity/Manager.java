package org.jaax.fase1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Manager {
    @Id
    @SequenceGenerator(
            name = "manager_sequence",
            sequenceName = "manager_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "manager_sequence",
            strategy = GenerationType.AUTO
    )
    private Long managerId;
    private String Firstname;
    private String Lastname;
}
