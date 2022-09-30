package devlsyjpashop2.devlsyjpashop2.repository;

import devlsyjpashop2.devlsyjpashop2.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
