package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**주문 리포지토리*/

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final EntityManager em;

    public void save(Order order) { //주문 엔티티를 저장
        em.persist(order);
    }

    public Order findOne(Long id) { //주문 엔티티를 검색
        return em.find(Order.class, id);
    }

    //주문 검색 기능
    // public List<Order> findAll(OrderSearch orderSearch) { ... }

}
