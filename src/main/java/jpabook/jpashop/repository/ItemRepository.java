package jpabook.jpashop.repository;
/*
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

상품 리포지토리

@Repository
//@RequiredArgsConstructor
public class ItemRepository {
    //private final EntityManager em;
    @PersistenceContext EntityManager em;

    이 메서드 하나로, 저장(새로운 엔티티 저장)과 수정(준영속엔티티 병합)을 한번에 처리
    public void save(Item item) {
        if (item.getId() == null) { //id(식별자)가 없으면, 새로운 엔티티로 보고
            em.persist(item);   //영속화 (persist()가 호출되면서 식별자 값이 자동으로 할당)
        }
        else {//id가 있으면, "이미 데이터베이스에 저장된 엔티티(준영속상태의 엔티티)를 수정"한다보고
            em.merge(item);     //병합
        }
    }


    public Item findOne(Long id) {

        return em.find(Item.class, id);
    }

    public List<Item> findAll() {

        return em.createQuery("select i from Item i",Item.class).getResultList();
    }
}
*/