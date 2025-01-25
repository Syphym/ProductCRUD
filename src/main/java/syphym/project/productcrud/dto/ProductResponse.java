package syphym.project.productcrud.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductResponse {
    private String messageCode;
    private List<ProductDTO> productDTO;
}
