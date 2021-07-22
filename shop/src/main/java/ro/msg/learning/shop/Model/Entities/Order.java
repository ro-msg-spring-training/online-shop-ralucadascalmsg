package ro.msg.learning.shop.Model.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.lang.*;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
public class Order extends BaseEntity {
      @ManyToOne(fetch = FetchType.EAGER)
      private Location shippedForm;
      @ManyToOne(fetch = FetchType.EAGER)
      private Customer customer;
      private LocalDateTime createdAt;
      private String addressCountry;
      private String addressCity;
      private String addressCounty;
      private String addressStreetAddress;
}
