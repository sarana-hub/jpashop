package jpabook.jpashop.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Order;

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
