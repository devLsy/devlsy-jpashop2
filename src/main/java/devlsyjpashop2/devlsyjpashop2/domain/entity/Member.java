package devlsyjpashop2.devlsyjpashop2.domain.entity;

import devlsyjpashop2.devlsyjpashop2.domain.dto.MemberDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "MEMBER")
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    //연관관계 주인이 아님
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @Builder
    public Member(Long memberId, String memberName, List<Order> orders) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.orders = orders;
    }

    /**
     * convert to entity form dto
     * @param memberDto
     * @return
     */
    public static Member convertToEntity(MemberDto memberDto) {
        return Member.builder()
                .memberName(memberDto.getMemberName())
                .build();
    }
}
