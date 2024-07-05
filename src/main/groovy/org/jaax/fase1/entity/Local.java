package org.jaax.fase1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="locals")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Local {

    @Id
    @SequenceGenerator(
            name = "local_sequence",
            sequenceName = "local_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "local_sequence",
            strategy = GenerationType.AUTO
    )
    private Long localId;
    @NotBlank(message = "please add the name")
    private String name;
    @Length(min=4, max=10, message = "please insert code min 4 characters and max 10 characters")
    private String code;
    private String floor;
    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "manager_id",
            referencedColumnName = "managerId"
    )
    private Manager manager;
}
