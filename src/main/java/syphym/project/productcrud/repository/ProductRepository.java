package syphym.project.productcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syphym.project.productcrud.entity.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
