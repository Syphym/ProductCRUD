package syphym.project.productcrud.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import syphym.project.productcrud.enums.RegionEnums;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Size(min = 20, message = "Description must be at least 20 characters long")
    @Column(name = "description", nullable = false)
    private String description;

    @PositiveOrZero(message = "Price must not be negative")
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @NotBlank(message = "Manufacturer is required")
    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @Column(name = "category_id")
    private UUID categoryID;

    @Enumerated(EnumType.STRING)
    @Column(name = "region", nullable = false)
    private RegionEnums region;

    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID();
    }
}