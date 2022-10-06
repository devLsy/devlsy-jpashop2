package devlsyjpashop2.devlsyjpashop2.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "order_book")
public class OrderBook {

    @Id
    @GeneratedValue
    @Column(name = "order_book_id")
    private Long orderBookId;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "book_id")
    private Long BookId;

    @Column(name = "order_price")
    private int orderPrice;

    @Column(name = "order_count")
    private int orderCount;

    @Builder
    public OrderBook(Long orderBookId, Long orderId, Long bookId, int orderPrice, int orderCount) {
        this.orderBookId = orderBookId;
        this.orderId = orderId;
        BookId = bookId;
        this.orderPrice = orderPrice;
        this.orderCount = orderCount;
    }
}
