package ro.msg.learning.shop.Model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.Model.Entities.OrderDetail;
import ro.msg.learning.shop.Model.Entities.Product;

import java.time.LocalDateTime;
import java.util.Collection;
@Data
@NoArgsConstructor
public class OrderRequestDTO {
    private LocalDateTime createdAt;
    private String addressCountry;
    private String addressCity;
    private String addressCounty;
    private String addressStreetAddress;
    private Collection <OrderedProductDTO> orderedProducts;
}
