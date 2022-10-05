package devlsyjpashop2.devlsyjpashop2.controller;

import devlsyjpashop2.devlsyjpashop2.domain.dto.BookDto;
import devlsyjpashop2.devlsyjpashop2.domain.dto.MemberDto;
import devlsyjpashop2.devlsyjpashop2.service.BookService;
import devlsyjpashop2.devlsyjpashop2.service.MemberService;
import devlsyjpashop2.devlsyjpashop2.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final BookService bookService;

    /**
     * 주문 폼 호출
     * @param model
     * @return
     */
    @GetMapping("/order")
    public String orderForm(Model model) {
        List<MemberDto> members = memberService.findAllMember();
        List<BookDto> books = bookService.findAllBook();

        model.addAttribute("members", members);
        model.addAttribute("books", books);

        return "order/orderForm";
    }

    /**
     * 주문 처리
     * @param memberId
     * @param bookId
     * @param count
     * @return
     * @throws Exception
     */
    @PostMapping("/order")
    public String createOrder(@RequestParam("memberId") Long memberId,
                            @RequestParam("bookId") Long bookId,
                            @RequestParam("count") int count) throws Exception{
        orderService.order(memberId, bookId, count);
        return "redirect:/orders";
    }
}
