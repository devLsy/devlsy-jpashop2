package devlsyjpashop2.devlsyjpashop2.repository;

import devlsyjpashop2.devlsyjpashop2.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
