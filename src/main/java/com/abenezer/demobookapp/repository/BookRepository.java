package com.abenezer.demobookapp.repository;

import com.abenezer.demobookapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
