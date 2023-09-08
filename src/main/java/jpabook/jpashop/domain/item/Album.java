package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**상품 - 음반 엔티티*/

@Entity
@DiscriminatorValue("A")
@Getter @Setter
public class Album extends Item{
    private String artist;
    private String etc;
}
