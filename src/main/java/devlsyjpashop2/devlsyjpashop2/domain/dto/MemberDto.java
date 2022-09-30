package devlsyjpashop2.devlsyjpashop2.domain.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import devlsyjpashop2.devlsyjpashop2.domain.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MemberDto {

    private Long memberId;
    private String memberName;

    /**
     * convert from entity to dto
     * @param member
     * @return
     */
    public static MemberDto convertToDto(Member member) {
        return MemberDto.builder()
                .memberId(member.getMemberId())
                .memberName(member.getMemberName())
                .build();
    }
}
