package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepository1;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;

@RequiredArgsConstructor
public class MemberServiceV1 {

    private final MemberRepository1 memberRepository1;

    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
        //시작
        Member fromMember = memberRepository1.findById(fromId);
        Member toMember = memberRepository1.findById(toId);

        memberRepository1.update(fromId, fromMember.getMoney() - money);
        validation(toMember);
        memberRepository1.update(toId, toMember.getMoney() + money);
        //커밋, 롤백

    }

    private void validation(Member toMember) {
        if(toMember.getMemberId().equals("ex")){
            throw new IllegalStateException("이체중 예외 발생");
        }
    }
}
