package ro.msg.learning.shop.Model;

import lombok.*;

import javax.persistence.*;

@MappedSuperclass
@NoArgsConstructor
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
