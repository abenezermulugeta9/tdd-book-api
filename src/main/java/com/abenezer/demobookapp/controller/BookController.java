package com.abenezer.demobookapp.controller;

import com.abenezer.demobookapp.model.Book;
import com.abenezer.demobookapp.service.BookService;
import com.abenezer.demobookapp.service.dto.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addProduct(@RequestBody BookRequest bookRequest){
        return ResponseEntity.ok(bookService.saveBook(bookRequest));
    }
}
