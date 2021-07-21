package ro.msg.learning.shop.Model.Entities;

import lombok.*;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Customer extends BaseEntity {
   private String firstName;
   private String lastName;
   private String username;
   private String password;
   private String emailAddress;
}
