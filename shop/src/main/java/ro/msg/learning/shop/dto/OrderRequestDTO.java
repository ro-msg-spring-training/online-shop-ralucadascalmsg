package ro.msg.learning.shop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

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
