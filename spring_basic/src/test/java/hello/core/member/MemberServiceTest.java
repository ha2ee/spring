package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void BeforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    
    @Test
    void join() {
        //given 이런이런게 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);
        
        //when 이렇게 했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then 이렇게 된다
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}
