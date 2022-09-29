package devlsyjpashop2.devlsyjpashop2.service;

import devlsyjpashop2.devlsyjpashop2.domain.dto.MemberDto;
import devlsyjpashop2.devlsyjpashop2.domain.entity.MemberEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @PostConstruct
    public void initDB() {
        for (int i = 0; i < 20; i++) {
            MemberDto memberDto = MemberDto.builder()
                    .name("member_" + i)
                    .build();
            memberService.join(memberDto);
        }
    }
    
    @Test
    public void 회원목록조회() throws Exception {
        //when
        List<MemberDto> allMember = memberService.findAllMember();

        //then
        assertThat(allMember.size()).isEqualTo(20);
    }
    
    @Test
    public void 회원단건조회() throws Exception {
        //when
        Long memberId = 20L;
        MemberDto oneMember = memberService.findOneMember(memberId);

        //then
        assertThat(oneMember.getName()).isEqualTo("member_19");
    }



}