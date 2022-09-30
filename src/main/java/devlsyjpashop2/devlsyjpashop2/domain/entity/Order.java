package devlsyjpashop2.devlsyjpashop2.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long orderId;

    //연관관계 주인
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany
    @JoinColumn(name = "ORDER_ID")
    private List<OrderBook> orderBooks = new ArrayList<>();

    //주문날짜
    @Column(name = "ORDER_DATE")
    @CreationTimestamp
    private LocalDateTime orderDate;

    //주문상태(주문, 취소)
    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS")
    private OrderStatus orderStatus;
}
