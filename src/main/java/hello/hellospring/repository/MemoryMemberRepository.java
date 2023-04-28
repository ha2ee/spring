package hello.hellospring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import hello.hellospring.domain.Member;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //실제 서비스에선 동시성 문제가 있을 수 있어서 ConcurrentHashMap을 사용한다.
    private static long sequence = 0L; // 마찬가지로 동시성 문제로 AtomicLong을 사용해야함.

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // 널이 반환 될 가능성이 있으면 Optional으로 감싸준다
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
            .filter(member -> member.getName().equals(name)) // member.getName()이 파라미터로 넘어온 String name 이랑 같은지 필터를 함. 같은 경우에만 필터링 된다.
            .findAny(); // 그중에서 찾으면 반환한다.
            //즉 맵을 돌면서 하나 찾아지면 그냥 걔를 반환하는데, 끝까지 돌리는데 없으면 옵셔널에 null이 포함돼서 반환된다.
    }

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public void clearStore() {
        store.clear();
    }
    
    
}
