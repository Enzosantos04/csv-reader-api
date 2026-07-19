package enzosdev.csvreaderapi.repository;


import enzosdev.csvreaderapi.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductsRepository extends JpaRepository<Products, Long> {
}
