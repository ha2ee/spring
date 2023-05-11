package hello.core.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //실무에선 동시성 문제로 인해 ConcurrnetHashMap을 사용해야함. 

    @Override
    public Member findById(Long memberId) {
       return store.get(memberId);
    }

    @Override
    public void save(Member member) {
        store.put(member.getId() , member);
    }
    
}
