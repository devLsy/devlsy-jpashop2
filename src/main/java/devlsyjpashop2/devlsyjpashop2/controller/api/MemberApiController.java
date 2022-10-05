package devlsyjpashop2.devlsyjpashop2.controller.api;

import devlsyjpashop2.devlsyjpashop2.domain.dto.MemberDto;
import devlsyjpashop2.devlsyjpashop2.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/member")
public class MemberApiController {
    
    private final MemberService memberService;

    /**
     * 회원가입
     * @param memberDto
     * @return
     */
    @PostMapping("/")
    public Long join(@RequestBody MemberDto memberDto) {
        return memberService.join(memberDto);
    }

    /**
     * 회원 단건 조회
     * @param memberId
     * @return
     */
    @GetMapping("/{memberId}")
    public MemberDto findMember(@PathVariable Long memberId) {
        return memberService.findOneMember(memberId);
    }

    /**
     * 회원 목록 조회
     * @return
     */
    @GetMapping("/")
    public List<MemberDto> findAllMember() {
        return memberService.findAllMember();
    }
    
}
