package devlsyjpashop2.devlsyjpashop2.domain.entity;

import devlsyjpashop2.devlsyjpashop2.domain.dto.MemberDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "MEMBER")
public class MemberEntity {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long memberId;

    private String name;

    @Builder
    public MemberEntity(Long memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    /**
     * convert from dto to entity
     * @param memberDto
     * @return
     */
    public static MemberEntity convertToEntity(MemberDto memberDto) {
        return MemberEntity.builder()
                .name(memberDto.getName())
                .build();
    }
}
