package ro.msg.learning.shop.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Model.Entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
