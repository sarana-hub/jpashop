package jpabook.jpashop.web;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**회원 등록 폼 객체*/
/*
 * 화면 계층과 서비스 계층을 명확하게 분리
 * 실무에서 엔티티는 핵심 비즈니스 로직만 가지고 있고, 화면을 위한 로직은 없어야 한다
 * ->화면이나 API에 맞는 폼 객체나 DTO를 사용
 * */

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수 입니다")
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
