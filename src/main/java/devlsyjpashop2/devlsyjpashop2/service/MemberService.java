package devlsyjpashop2.devlsyjpashop2.service;

import devlsyjpashop2.devlsyjpashop2.domain.dto.MemberDto;
import devlsyjpashop2.devlsyjpashop2.domain.entity.MemberEntity;
import devlsyjpashop2.devlsyjpashop2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static devlsyjpashop2.devlsyjpashop2.domain.dto.MemberDto.convertToDto;
import static devlsyjpashop2.devlsyjpashop2.domain.entity.MemberEntity.convertToEntity;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 등록
     * @param memberDto
     * @return
     */
    public Long join(MemberDto memberDto) {
        MemberEntity saveMember = memberRepository.save(convertToEntity(memberDto));
        return saveMember.getMemberId();
    }

    /**
     * 회원 단건 조회
     * @return
     */
    @Transactional(readOnly = true)
    public MemberDto findOneMember(Long memberId) {
        Optional<MemberEntity> findMember = memberRepository.findById(memberId);
        return convertToDto(findMember.get());
    }

    /**
     * 회원 목록 조회
     * @return
     */
    @Transactional(readOnly = true)
    public List<MemberDto> findAllMember() {
        List<MemberEntity> findMembers = memberRepository.findAll();
// stream 이용
        List<MemberDto> result = findMembers.stream()
                .map(entity -> convertToDto(entity)).collect(toList());
        return result;
// 일반 foreach
//        List<MemberDto> result = new ArrayList<>();
//        for (MemberEntity m : findMembers) {
//            MemberDto memberDto = convertToDto(m);
//            result.add(memberDto);
//        }
    }

}
