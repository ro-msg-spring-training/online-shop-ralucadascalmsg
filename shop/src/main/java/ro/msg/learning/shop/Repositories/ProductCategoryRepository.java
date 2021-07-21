package ro.msg.learning.shop.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Model.Entities.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{
}
