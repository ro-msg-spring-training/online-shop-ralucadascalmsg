package ro.msg.learning.shop.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Model.Entities.Location;
import ro.msg.learning.shop.Model.Entities.Product;
import ro.msg.learning.shop.Model.Entities.Stock;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock,Integer> {
    Optional<Stock> findByProductAndLocation(Product product, Location location);


}
