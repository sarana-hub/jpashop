package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**회원 리포지토리*/

@Repository     //스프링 빈으로 등록
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;
    /*@PersistenceContext     //엔티티 메니저(EntityManager) 주입 (JPA 사용하므로)
    private EntityManager em;*/

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name=:name", Member.class)
                .setParameter("name",name)
                .getResultList();
    }

}
