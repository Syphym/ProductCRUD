package syphym.project.productcrud.dto;

import lombok.Builder;
import lombok.Data;
import syphym.project.productcrud.entity.Category;
import syphym.project.productcrud.enums.RegionEnums;

import javax.swing.plaf.synth.Region;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class ProductDTO {
    private UUID id;
    private String description;
    private BigDecimal price;
    private String manufacturer;
    private String category;
    private RegionEnums regionEnums;
}
