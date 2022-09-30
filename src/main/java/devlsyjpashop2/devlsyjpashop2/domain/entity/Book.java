package devlsyjpashop2.devlsyjpashop2.domain.entity;


import devlsyjpashop2.devlsyjpashop2.domain.dto.BookDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "BOOK")
public class Book {

    @Id @GeneratedValue
    @Column(name = "BOOK_ID")
    private Long bookId;

    @Column(name = "BOOK_NAME")
    private String bookName;

    @Column(name = "BOOK_PRICE")
    private int bookPrice;

    @Column(name = "BOOK_STOCK_QUANTITY")
    private int bookStockQuantity;

    @Column(name = "BOOK_AUTHOR")
    private String bookAuthor;

    @Column(name = "BOOK_ISBN")
    private String bookIsbn;

    @Builder
    public Book(Long bookId, String bookName, int bookPrice, int bookStockQuantity, String bookAuthor, String bookIsbn) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookStockQuantity = bookStockQuantity;
        this.bookAuthor = bookAuthor;
        this.bookIsbn = bookIsbn;
    }

    /**
     * convert to entity from dto
     * @param bookDto
     * @return
     */
    public static Book toEntity(BookDto bookDto) {
        return Book.builder()
                .bookId((bookDto.getBookId()))
                .bookName(bookDto.getBookName())
                .bookPrice(bookDto.getBookPrice())
                .bookStockQuantity(bookDto.getBookStockQuantity())
                .bookAuthor(bookDto.getBookAuthor())
                .bookIsbn(bookDto.getBookIsbn())
                .build();
    }
}
