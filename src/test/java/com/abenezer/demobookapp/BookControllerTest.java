package com.abenezer.demobookapp;

import com.abenezer.demobookapp.controller.BookController;
import com.abenezer.demobookapp.service.BookService;
import com.abenezer.demobookapp.service.dto.BookRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @BeforeEach
    public void beforeEach() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(bookController)
                .build();
    }

    @Test
    @SneakyThrows
    public void shouldCreateANewBook() {
        BookRequest bookRequest = createBookRequestObject("You're a bad ass", "112FAGDAGH215", "Jen Sencero");

        ObjectMapper objectMapper = new ObjectMapper();

        String bookRequestAsString = objectMapper.writeValueAsString(bookRequest);

        mockMvc
                .perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookRequestAsString))
                .andExpect(status().isOk());
    }

    private BookRequest createBookRequestObject(String title, String isbn, String author) {
        return BookRequest.builder()
                .title(title)
                .isbn(isbn)
                .author(author)
                .build();
    }
}
