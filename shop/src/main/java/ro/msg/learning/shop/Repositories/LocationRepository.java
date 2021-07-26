package ro.msg.learning.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.model.Location;

public interface LocationRepository extends JpaRepository<Location,Integer> {
}
