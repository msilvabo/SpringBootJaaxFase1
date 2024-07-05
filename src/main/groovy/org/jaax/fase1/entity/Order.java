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
@Table(name = "tbl_order")
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_seguence",
            sequenceName = "order_seguence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "order_seguence",
            strategy = GenerationType.SEQUENCE
    )
    private Long orderid;
    private String description;
    private double price;

}
