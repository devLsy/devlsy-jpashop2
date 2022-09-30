package devlsyjpashop2.devlsyjpashop2.repository;

import devlsyjpashop2.devlsyjpashop2.domain.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;


    @PostConstruct
    public void initDB() {
        for (int i = 0; i < 30; i++) {
            Member member = Member.builder()
                    .memberName("회원_" + i)
                    .build();
            memberRepository.save(member);
        }
    }

    @Test
    @Transactional(readOnly = true)
    public void 회원_단건조회() throws Exception {
        //when
//        MemberEntity findMember = memberRepository.findByMemberId(5L);

        //then
//        assertThat(findMember.getName()).isEqualTo("");
//        assertThat(findMember.getName()).isEqualTo("헐크");
    }

    @Test
    @Transactional(readOnly = true)
    public void 회원_목록조회() throws Exception {
        //when
        List<Member> all = memberRepository.findAll();
        //then
        Assertions.assertThat(all.size()).isEqualTo(30);

    }

}