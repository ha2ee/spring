package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;

public interface MemberRepository {
    Member save(Member member); //회원을 저장
    Optional<Member> findbyId(Long id); // 회원을 찾을 수 있다
    Optional<Member> findbyName(String name); // 회원을 찾을 수 있다.
    List<Member> findAll(); // 지금까지 저장된 모든 회원 리스트를 반환한다.
}
