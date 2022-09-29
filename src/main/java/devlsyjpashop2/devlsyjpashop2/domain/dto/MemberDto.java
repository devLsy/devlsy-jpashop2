package devlsyjpashop2.devlsyjpashop2.domain.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import devlsyjpashop2.devlsyjpashop2.domain.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MemberDto {

    private Long memberId;
    private String name;

    /**
     * convert from entity to dto
     * @param memberEntity
     * @return
     */
    public static MemberDto convertToDto(MemberEntity memberEntity) {
        return MemberDto.builder()
                .name(memberEntity.getName())
                .build();
    }
}
