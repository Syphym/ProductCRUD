package syphym.project.productcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syphym.project.productcrud.entity.Category;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
