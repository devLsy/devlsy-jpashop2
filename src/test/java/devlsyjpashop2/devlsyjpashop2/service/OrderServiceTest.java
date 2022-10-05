package devlsyjpashop2.devlsyjpashop2.service;

import devlsyjpashop2.devlsyjpashop2.domain.entity.Book;
import devlsyjpashop2.devlsyjpashop2.domain.entity.Member;
import devlsyjpashop2.devlsyjpashop2.domain.entity.Order;
import devlsyjpashop2.devlsyjpashop2.repository.BookRepository;
import devlsyjpashop2.devlsyjpashop2.repository.MemberRepository;
import devlsyjpashop2.devlsyjpashop2.repository.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional(readOnly = true)
class OrderServiceTest {

    @Autowired MemberRepository memberRepository;
    @Autowired OrderRepository orderRepository;
    @Autowired OrderService orderService;
    @Autowired BookRepository bookRepository;

    @Test
    @Transactional
    @Commit
    public void 상품주문() throws Exception {
        //givin
        Optional<Member> findMember = memberRepository.findById(1L);
        Optional<Book> findBook = bookRepository.findById(11L);

        Order order = Order.builder()
                .member(findMember.get())
                .build();
        //when
//        Long saveOrder = orderService.order(findMember.get().getMemberId(), book.getBookId(), 1);
        Order saveOrder = orderRepository.save(order);

        //then
        Assertions.assertThat(saveOrder.getMember().getMemberId()).isEqualTo(1);
    }


}