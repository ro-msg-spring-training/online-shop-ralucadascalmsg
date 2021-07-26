package ro.msg.learning.shop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@SuperBuilder
public class ProductDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private double weight;
    private int category_id;
    private int supplier_id;
    private String category;
    private String supplier;
    private String imageUrl;
    private String descriptionCategory;

}
