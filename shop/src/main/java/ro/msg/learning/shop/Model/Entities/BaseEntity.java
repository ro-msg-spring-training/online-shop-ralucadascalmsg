package ro.msg.learning.shop.Model.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
//Subpachet Model--o clasa DTO contine build-uri din declar toate campurile din product si pc
// O clasa service cu clasa care opereaza crud pe
@MappedSuperclass
@NoArgsConstructor
@Data
@SuperBuilder
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
