package devlsyjpashop2.devlsyjpashop2.repository;

import devlsyjpashop2.devlsyjpashop2.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

}
