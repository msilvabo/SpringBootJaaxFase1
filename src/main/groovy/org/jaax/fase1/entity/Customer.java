package org.jaax.fase1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name="tbl_customer",
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique",
                columnNames = "email_address"
        )
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "customer_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long customerid;
    private String firstname;
    private String lastname;
    @Column(
            name = "email_address",
            nullable = false
    )
    private String email;

//    private String customerCity;
//    private String customerMainStreet;
//    private String customerSecondaryStreet;

    @Embedded
    private Address address;
}
