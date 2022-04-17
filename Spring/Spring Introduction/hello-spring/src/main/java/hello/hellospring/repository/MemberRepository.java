package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member); // 회원이 저장된다
    // Optional : findById 혹은 findByName에서 null값으로 반환될 때, null값을 처리하기 위해서
    // Optional에 감싸서 반환시키는 방식이다
    Optional<Member> findById(Long id); //저장소에서 Id나 Name을 찾아올 수 있다
    Optional<Member> findByName(String name);
    List<Member> findAll();
 }
