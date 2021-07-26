package ro.msg.learning.shop.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@SuperBuilder
public class Customer extends BaseEntity {
   private String firstName;
   private String lastName;
   private String username;
   private String password;
   private String emailAddress;
}
