package ro.msg.learning.shop.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Model.Entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
}
