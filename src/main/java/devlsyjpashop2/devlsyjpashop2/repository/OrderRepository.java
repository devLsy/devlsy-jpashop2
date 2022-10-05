package devlsyjpashop2.devlsyjpashop2.repository;

import devlsyjpashop2.devlsyjpashop2.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
