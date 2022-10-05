package devlsyjpashop2.devlsyjpashop2.service;

import devlsyjpashop2.devlsyjpashop2.domain.dto.MemberDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

//    @PostConstruct
//    public void initDB() {
//        for (int i = 0; i < 20; i++) {
//            MemberDto memberDto = MemberDto.builder()
//                    .name("member_" + i)
//                    .build();
//            memberService.join(memberDto);
//        }
//    }
    @Test
    public void 회원가입() throws Exception{
        MemberDto memberDto = MemberDto.builder()
                .memberName("시발")
                        .build();
//        memberService.join(memberDto);
//        assertThat(memberDto.getMemberName()).isEqualTo("시발");
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
        Long memberId = 10L;
        MemberDto oneMember = memberService.findOneMember(memberId);

        //then
        assertThat(oneMember.getMemberName()).isEqualTo("member_10");
    }



}