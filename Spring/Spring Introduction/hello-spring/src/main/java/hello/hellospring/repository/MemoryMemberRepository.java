package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    // 아래처럼 코드를 작성하였다. 우리는 이 코드가 잘 작동되는지 확인해야 한다
    // 이럴 때, testcase를 작성해서 확인이 가능하다

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // 1. Id를 셋팅한다
        store.put(member.getId(), member); // 2. store에 저장한다
        return member; // 3. member로 반환한다
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
