package devlsyjpashop2.devlsyjpashop2.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "ORDER_BOOK_MAPPING")
public class OrderBook {

    @Id @GeneratedValue
    @Column(name = "ORDER_BOOK_ID")
    private Long orderItemId;
    
    // 연관관계 주인
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    // 연관관계 주인
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;
    
    // 주문가격
    @Column(name = "ORDER_PRICE")
    private int orderPrice;

    // 주문 수량
    private int count;
}
