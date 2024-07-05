package org.jaax.fase1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name="locals")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "manager")
public class Local {

    @Id
    @SequenceGenerator(
            name = "local_sequence",
            sequenceName = "local_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "local_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long local_id;

    @NotBlank(message = "please add the name")
    private String name;
    @Length(min=4, max=10, message = "please insert code min 4 characters and max 10 characters")
    private String code;
    private String floor;
    @OneToOne(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER,
            optional = true
    )
    @JoinColumn(
            name = "manager_id",
            referencedColumnName = "managerId"
    )
    private Manager manager;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "local_id",
            referencedColumnName = "local_id"
    )
    private List<Order> orders;
}
