package ro.msg.learning.shop.Model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class OrderDetail extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    private Order order;
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;
    private int quantity;
}
