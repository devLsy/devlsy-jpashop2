package devlsyjpashop2.devlsyjpashop2.controller;

import devlsyjpashop2.devlsyjpashop2.domain.dto.MemberDto;
import devlsyjpashop2.devlsyjpashop2.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;


    /**
     * 회원가입 양식
     * @param model
     * @return
     */
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", MemberDto.builder().memberName("").build());
        return "member/createForm";
    }

    /**
     * 회원가입 처리
     * @param memberDto
     * @return
     */
    @PostMapping("/new")
    public String createMember(MemberDto memberDto) {
        memberService.join(memberDto);
        return "redirect:/";
    }

}
