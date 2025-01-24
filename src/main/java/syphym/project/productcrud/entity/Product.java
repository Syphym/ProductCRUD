package syphym.project.productcrud.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import syphym.project.productcrud.enums.RegionEnums;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id")
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

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;


    @Column(name = "region", nullable = false)
    @Enumerated(EnumType.STRING)
    private RegionEnums region;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;
}