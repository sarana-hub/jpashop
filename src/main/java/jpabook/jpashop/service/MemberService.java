package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**회원 서비스*/

@Service
@Transactional(readOnly = true)     //트랜잭션, 영속성 컨텍스트
/*readOnly=true 데이터의 변경이 없는 "읽기" 전용 메서드에 사용 (읽기 전용에는 다 적용)
영속성 컨텍스트를 플러시 하지 않으므로 약간의 성능 향상*/
@RequiredArgsConstructor    //final 붙은 필드만 사용해서 생성자를 생성
public class MemberService {

    private final MemberRepository memberRepository;  //필드 주입

    /**
     * 회원가입
     */
    @Transactional //변경 (읽기아닌 쓰기이므로, readOnly=false)
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());   //같은이름있는지
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {     //읽기
        return memberRepository.findAll();
    }
    public Member findOne(Long memberId) {  //읽기
        return memberRepository.findOne(memberId);
    }

}
