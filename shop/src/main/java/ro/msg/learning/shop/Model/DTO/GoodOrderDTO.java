package ro.msg.learning.shop.Model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.Model.Entities.ProductCategory;
import ro.msg.learning.shop.Model.Entities.Supplier;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
public class GoodOrderDTO {
    private String nameProduct;
    private BigDecimal price;
    private String nameLocation;
    private int quantity;

}
