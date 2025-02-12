package syphym.project.productcrud.controller;

import syphym.project.productcrud.dto.ProductResponse;
import syphym.project.productcrud.entity.Product;

public interface ProductController {

    Product getProductByID(String id);

    ProductResponse getAllProducts();

    ProductResponse getAllOrderedProducts(String order);

    ProductResponse getAllOrderProductByCriteria(String criteria);

    public String sanityCheck();
}
