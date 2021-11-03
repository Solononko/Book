package com.cryptocurrency.demo.service;

import com.cryptocurrency.demo.dto.BookCreateDto;
import com.cryptocurrency.demo.dto.BookPage;
import com.cryptocurrency.demo.entity.Book;

public interface BookService {


    BookPage getAllBooks(int page, int size);

    Book getBookById(int id);

    BookCreateDto createBook(BookCreateDto book);

    Book updateMovie(int id, Book movie);

    void deleteBook(int id);

    String getBookByTitle(String title);

}
