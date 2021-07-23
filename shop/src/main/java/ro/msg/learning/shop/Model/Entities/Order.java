package ro.msg.learning.shop.Model.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.lang.*;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper=true)
@SuperBuilder
public class Order extends BaseEntity {
      @ManyToOne(fetch = FetchType.EAGER)
      @JoinColumn(name = "location_id", referencedColumnName = "id")
      private Location shippedForm;
      @ManyToOne(fetch = FetchType.EAGER)
      @JoinColumn(name = "customer_id", referencedColumnName = "id")
      private Customer customer;
      private LocalDateTime createdAt;
      private String addressCountry;
      private String addressCity;
      private String addressCounty;
      private String addressStreetAddress;
}
