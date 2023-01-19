package com.abenezer.demobookapp.service;

import com.abenezer.demobookapp.model.Book;
import com.abenezer.demobookapp.repository.BookRepository;
import com.abenezer.demobookapp.service.dto.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(BookRequest bookRequest) {
        Book book = Book.builder()
                .author(bookRequest.getAuthor())
                .isbn(bookRequest.getIsbn())
                .title(bookRequest.getTitle())
                .build();

        bookRepository.save(book);
        return book;
    }
}
