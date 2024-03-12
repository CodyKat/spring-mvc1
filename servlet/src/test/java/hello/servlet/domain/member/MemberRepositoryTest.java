package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach()
    {
        memberRepository.clearStore();
    }


    @Test
    void save() {
        Member member = new Member("hello", 20);

        Member savedMember = memberRepository.save(member);

        Member findmember = memberRepository.findById(savedMember.getId());
        assertThat(findmember).isEqualTo(savedMember);
    }

    @Test
    void findAll()
    {
        Member member1 = new Member("member1", 10);
        Member member2 = new Member("member2", 10);

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }
}
