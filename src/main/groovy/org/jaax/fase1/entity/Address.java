package org.jaax.fase1.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name = "city",
                column = @Column(name = "customerCity")
        ),
        @AttributeOverride(
                name = "mainStreet",
                column = @Column(name = "customerMainStreet")
        ),
        @AttributeOverride(
                name = "secondaryStreet",
                column = @Column(name = "customerSecondaryStreet")
        )
})
public class Address {
    private String city;
    private String mainStreet;
    private String secondaryStreet;
}
