package syphym.project.productcrud.service;

import org.springframework.stereotype.Service;
import syphym.project.productcrud.dto.ProductDTO;
import syphym.project.productcrud.dto.ProductResponse;
import syphym.project.productcrud.entity.Product;
import syphym.project.productcrud.repository.ProductRepository;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductByID(String id) {
        return productRepository.findById(UUID.fromString(id)).get();
    }

    @Override
    public ProductResponse getProducts() {
        List<Product> allProducts = productRepository.findAll();

        List<ProductDTO> productDTOs  = allProducts.stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .manufacturer(product.getManufacturer())
                        .category(product.getCategory() != null ? product.getCategory().getName():null)
                        .regionEnums(product.getRegion())
                        .build())
                .collect(Collectors.toList());

        return ProductResponse.builder()
                .messageCode("200 - Success")
                .productDTO(productDTOs)
                .build();
    }

    @Override
    public ProductResponse getProductsOrderBy(String order) {

        List<Product> orderedProducts = Collections.emptyList();
        if (order.equals("manufacturer")){
            orderedProducts = productRepository.findAllByOrderByManufacturerAsc();
        }
        if (order.equals("price")){
            orderedProducts = productRepository.findAllByOrderByPriceDesc();
        }

        List<ProductDTO> productDTOS = orderedProducts.stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .manufacturer(product.getManufacturer())
                        .category(product.getCategory() != null ? product.getCategory().getName():null)
                        .regionEnums(product.getRegion())
                        .build())
                .collect(Collectors.toList());



        return ProductResponse.builder()
                .messageCode("200 - Success")
                .productDTO(productDTOS)
                .build();
    }

    @Override
    public ProductResponse getAllOrderProductByCriteria(String criteria) {
        return null;
    }


}
