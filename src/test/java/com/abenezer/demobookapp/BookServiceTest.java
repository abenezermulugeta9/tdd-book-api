package com.abenezer.demobookapp;

import com.abenezer.demobookapp.model.Book;
import com.abenezer.demobookapp.service.BookService;
import com.abenezer.demobookapp.service.dto.BookRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void shouldSaveBook() {
        BookRequest bookRequest = createBookObject("You're a bad ass", "112FAGDAGH215", "Jen Sencero");

        Book returnedBook = bookService.saveBook(bookRequest);

        Assertions.assertNotNull(returnedBook);
        Assertions.assertNotNull(returnedBook.getId());
        Assertions.assertEquals("You're a bad ass", returnedBook.getTitle());
    }

    private BookRequest createBookObject(String title, String isbn, String author) {
        return BookRequest.builder()
                .isbn(isbn)
                .title(title)
                .author(author)
                .build();
    }
}
