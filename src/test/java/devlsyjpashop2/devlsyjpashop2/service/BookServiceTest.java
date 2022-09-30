package devlsyjpashop2.devlsyjpashop2.service;

import devlsyjpashop2.devlsyjpashop2.domain.dto.BookDto;
import devlsyjpashop2.devlsyjpashop2.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class BookServiceTest {

    @Autowired
    BookService bookService;
    @Autowired
    BookRepository bookRepository;
    
    @Test
    @Rollback(false)
    public void 책등록() throws Exception {
        //given
        BookDto bookDto = BookDto.builder()
                .bookName("JAVA ORM 표준 JPA 프로그래밍 완전 마스터 1")
                .bookPrice(10000)
                .bookStockQuantity(10)
                .bookAuthor("아이언맨")
                .bookIsbn("123dts")
                .build();

        //when
        Long saveBookId = bookService.createBook(bookDto);

        //then
        BookDto findBook = bookService.findOneBook(saveBookId);

        assertThat(findBook.getBookName()).isEqualTo("JAVA ORM 표준 JPA 프로그래밍 완전 마스터 1");
    }
    
    @Test
    public void 책목록조회() throws Exception {
        //when
        List<BookDto> allBook = bookService.findAllBook();

        //then
        assertThat(allBook.size()).isEqualTo(10);
    }





}