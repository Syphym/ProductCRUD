package syphym.project.productcrud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import syphym.project.productcrud.dto.ProductResponse;
import syphym.project.productcrud.entity.Product;
import syphym.project.productcrud.service.ProductService;

import java.util.UUID;

@RestController
public class ProductControllerImpl implements ProductController{

    private final ProductService productService;

    public ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/SanityCheck")
    public String sanityCheck() {
        return "CodeBase is running as intended";
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Product getProductByID(@PathVariable String id) {
        return productService.getProductByID(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ProductResponse getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/all/ordered")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ProductResponse getAllOrderedProducts(@RequestParam String orderBy) {
        return productService.getProductsOrderBy(orderBy);
    }

    @Override
    public ProductResponse getAllOrderProductByCriteria(String criteria) {
        return productService.getAllOrderProductByCriteria(criteria);
    }

}
