package ro.msg.learning.shop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Data
@SuperBuilder
public class OrderedProductDTO {
    private int id;
    private int quantity;
}
