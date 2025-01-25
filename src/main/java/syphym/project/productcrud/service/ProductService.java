package syphym.project.productcrud.service;

import syphym.project.productcrud.dto.ProductResponse;
import syphym.project.productcrud.entity.Product;

import java.util.List;

public interface ProductService {

    Product getProductByID(String id);

   ProductResponse getProducts();


}
