package ro.msg.learning.shop.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
   Customer findByUsername(String username);
}
