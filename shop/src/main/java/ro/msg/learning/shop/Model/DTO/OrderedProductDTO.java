package ro.msg.learning.shop.Model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OrderedProductDTO {
    private int id;
    private int quantity;
}
