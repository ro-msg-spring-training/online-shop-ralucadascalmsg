package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class ProductCategory extends BaseEntity{
   private String name;
   private String description;

}
