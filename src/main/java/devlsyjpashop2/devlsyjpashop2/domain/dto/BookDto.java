package devlsyjpashop2.devlsyjpashop2.domain.dto;

import devlsyjpashop2.devlsyjpashop2.domain.entity.Book;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookDto {

    private Long bookId;
    private String bookName;
    private int bookPrice;
    private int bookStockQuantity;
    private String bookAuthor;
    private String bookIsbn;

    /**
     * convert from entity to dto
     * @return
     */
    public static BookDto toItemDto(Book book) {
        return BookDto.builder()
                .bookId(book.getBookId())
                .bookName(book.getBookName())
                .bookPrice(book.getBookPrice())
                .bookStockQuantity(book.getBookStockQuantity())
                .bookAuthor(book.getBookAuthor())
                .bookIsbn(book.getBookIsbn())
                .build();
    }
}
