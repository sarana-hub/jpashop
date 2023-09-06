package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**회원 리포지토리*/

@Repository
public class MemberRepository {

    @PersistenceContext     //스프링이 만들어둔 EntityManager를 빈으로 주입해준다
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
