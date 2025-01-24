package syphym.project.productcrud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import syphym.project.productcrud.entity.Product;
import syphym.project.productcrud.repository.ProductRepository;

import java.util.UUID;

@RestController
@RequestMapping("/SanityCheck")
public class ProductControllerImpl {

    private final ProductRepository productRepository;

    public ProductControllerImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping
    public String sanityCheck(){
        return "CodeBase is running as intended";
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Product getProductByID(@PathVariable String id){
        return productRepository.findById(UUID.fromString(id)).get();
    }
}
