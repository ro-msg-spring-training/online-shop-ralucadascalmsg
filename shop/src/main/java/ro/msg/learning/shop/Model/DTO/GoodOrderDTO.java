package ro.msg.learning.shop.Model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.msg.learning.shop.Model.Entities.ProductCategory;
import ro.msg.learning.shop.Model.Entities.Supplier;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
@SuperBuilder
public class GoodOrderDTO {
    private String nameProduct;
    private String nameLocation;
    private int quantity;

}
