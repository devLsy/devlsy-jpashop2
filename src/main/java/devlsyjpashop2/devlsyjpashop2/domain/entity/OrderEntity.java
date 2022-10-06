package devlsyjpashop2.devlsyjpashop2.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long orderId;

    //    @JoinColumn(name = "member_id")
//    private List<MemberEntity> members = new ArrayList<>();
    @CreationTimestamp
    @Column(name = "order_date")
    private LocalDateTime orderDate;

    private OrderStatus orderStatus;
}
