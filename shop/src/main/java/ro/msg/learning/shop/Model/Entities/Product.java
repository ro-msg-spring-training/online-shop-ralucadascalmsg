package ro.msg.learning.shop.Model.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@SuperBuilder
@EqualsAndHashCode(callSuper=true)
public class Product extends BaseEntity {
     private String name;
     private String description;
     private BigDecimal price;
     private double weight;
     @ManyToOne(fetch = FetchType.EAGER)
     private ProductCategory category;
     @ManyToOne(fetch = FetchType.EAGER)
     private Supplier supplier;
     private String ImageUrl;
}
