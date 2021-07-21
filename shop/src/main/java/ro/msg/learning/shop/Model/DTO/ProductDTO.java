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

public class ProductDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private double weight;
    private int category_id;
    private int supplier_id;
    private String category;
    private String supplier;
    private String ImageUrl;
    private String descriptionCategory;

}
