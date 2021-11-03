package com.cryptocurrency.demo.controller;

import com.cryptocurrency.demo.dto.BookCreateDto;
import com.cryptocurrency.demo.dto.BookPage;
import com.cryptocurrency.demo.entity.Book;
import com.cryptocurrency.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/book")
public class BookController {
    private static final Logger LOG = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookService bookService;

    //        @Autowired
//        private BookValidator bookValidator;
    @GetMapping
    public BookPage getBooks(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
        return bookService.getAllBooks(page, size);
    }

    @GetMapping("/title{title}")
    public Book getBookByTitle(@PathVariable String title) {
        return bookService.getBookByTitle(title);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookCreateDto insertBook(@RequestBody @Valid BookCreateDto book) {
        LOG.info("Handling post request for object{},", book);
        return bookService.createBook(book);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Book updateBook(@PathVariable int id, @RequestBody @Valid Book book) {
        return bookService.updateMovie(id, book);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }
}
