package ro.msg.learning.shop.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.model.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
}
