package devlsyjpashop2.devlsyjpashop2.service;

import devlsyjpashop2.devlsyjpashop2.domain.dto.BookDto;
import devlsyjpashop2.devlsyjpashop2.domain.entity.Book;
import devlsyjpashop2.devlsyjpashop2.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

import static devlsyjpashop2.devlsyjpashop2.domain.dto.BookDto.toItemDto;
import static java.util.stream.Collectors.toList;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    // 초기 데이터 세팅
    @PostConstruct
    public void initDB() {
        for (int i = 1; i < 11; i++) {
            int price = 100;
            BookDto bookDto = BookDto.builder()
                    .bookName("JAVA ORM 표준 JPA 프로그래밍 " + i)
                    .bookPrice(price + i)
                    .bookStockQuantity(10)
                    .bookAuthor("아이언맨")
                    .bookIsbn("1009dtac")
                    .build();
            bookRepository.save(Book.toEntity(bookDto));
        }
    }

    /**
     * 상품 등록
     *
     * @param
     * @return
     */
    public Long createBook(BookDto bookDto) {
        Book saveBook = bookRepository.save(Book.toEntity(bookDto));
        return saveBook.getBookId();
    }

    /**
     * 상품 단건 조회
     *
     * @param
     * @return
     */
    public BookDto findOneBook(Long bookId) {
        Optional<Book> findBook = bookRepository.findById(bookId);
        return toItemDto(findBook.get());
    }

    /**
     * 상품 목록 조회
     *
     * @return
     */
    public List<BookDto> findAllBook() {
        List<Book> findBooks = bookRepository.findAll();
        List<BookDto> result = findBooks.stream()
                .map(book -> toItemDto(book)).collect(toList());
        return result;
    }

    /**
     * 상품 수정
     * @param bookId
     * @param bookName
     * @param bookPrice
     * @param bookStockQuantity
     */
    public void updateBook(Long bookId, String bookName, int bookPrice, int bookStockQuantity) {
//        Optional<Book> findBook = bookRepository.findById(bookId);
//        나중에 구현
    }


}
