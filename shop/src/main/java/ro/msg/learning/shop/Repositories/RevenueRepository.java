package ro.msg.learning.shop.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.model.Revenue;

public interface RevenueRepository extends JpaRepository<Revenue,Integer>{
}
