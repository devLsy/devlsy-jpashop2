package devlsyjpashop2.devlsyjpashop2.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
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
    private List<OrderBookMapping> orderBookMappings = new ArrayList<>();

    //주문날짜
    @Column(name = "ORDER_DATE")
    @CreationTimestamp
    private LocalDateTime orderDate;

    //주문상태(주문, 취소)
    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS")
    private OrderStatus orderStatus;

    @Builder
    public Order(Long orderId, Member member, List<OrderBookMapping> orderBookMappings) {
        this.orderId = orderId;
        this.member = member;
        this.orderBookMappings = orderBookMappings;
        this.orderDate = LocalDateTime.now();
        this.orderStatus = OrderStatus.ORDER;
    }
}
