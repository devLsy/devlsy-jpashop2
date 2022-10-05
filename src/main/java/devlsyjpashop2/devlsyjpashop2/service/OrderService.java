package devlsyjpashop2.devlsyjpashop2.service;

import devlsyjpashop2.devlsyjpashop2.domain.entity.Book;
import devlsyjpashop2.devlsyjpashop2.domain.entity.Member;
import devlsyjpashop2.devlsyjpashop2.domain.entity.Order;
import devlsyjpashop2.devlsyjpashop2.repository.BookRepository;
import devlsyjpashop2.devlsyjpashop2.repository.MemberRepository;
import devlsyjpashop2.devlsyjpashop2.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    /**
     * 상품 주문
     * @param memberId
     * @param bookId
     * @param count
     * @return
     */
    public Long order(Long memberId, Long bookId, int count) {
        Optional<Member> findMember = memberRepository.findById(memberId);
        Optional<Book> findBook = bookRepository.findById(bookId);

        Order order = Order.builder()
                .member(findMember.get())
                .build();

        Order saveOrder = orderRepository.save(order);
        return saveOrder.getOrderId();
    }

}
