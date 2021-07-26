package ro.msg.learning.shop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class OrderResponseDTO {
    private String nameProduct;
    private String nameLocation;
    private int quantity;

}
