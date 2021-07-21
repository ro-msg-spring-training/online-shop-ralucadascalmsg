package ro.msg.learning.shop.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Model.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
}
