package ro.msg.learning.shop.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Stock;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock,Integer> {
    Optional<Stock> findByProductAndLocation(Product product, Location location);


}
