package com.cryptocurrency.demo.service;

import com.cryptocurrency.demo.dao.BookDao;
import com.cryptocurrency.demo.dto.BookCreateDto;
import com.cryptocurrency.demo.dto.BookDto;
import com.cryptocurrency.demo.dto.BookPage;
import com.cryptocurrency.demo.entity.Book;
import org.apache.commons.lang3.CharUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    AuthorService authorService;
    @Override
    public BookPage getAllBooks(int page, int size) {

        Page<Book> books = bookDao.findAll(PageRequest.of(page, size));
        final BookPage bookPage= new BookPage();
        List<Book> content = books.getContent();
        bookPage.setBooks(content.stream().map(book ->{BookDto bookDto= new BookDto();
        bookDto.setBookId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setPrice(book.getPrice());
        bookDto.setAuthorId(book.getAuthor().getId());
        return bookDto;
        }

         ).collect(Collectors.toList()));
        bookPage.setCurrentPage(books.getNumber());
        bookPage.setLast(books.isLast());
        bookPage.setTotalElement(books.getTotalPages());
        return bookPage;
    }
    @Override
    public BookCreateDto createBook(BookCreateDto book) {
        if(!CharUtils.isAsciiAlphaUpper(book.getTitle().charAt(0))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Title should start with capital letter");
        }
        Book bookDb = new Book();
        bookDb.setTitle(book.getTitle());
        bookDb.setPrice(book.getPrice());
        bookDb.setAuthor(authorService.getAuthorById(book.getAuthorId()));
        final Book savedBook = bookDao.saveAndFlush(bookDb);
       book.setId(savedBook.getId());
        return book;
    }

    @Override
    public Book updateMovie(int id, Book book) {
        book.setId(id);
        if( !bookDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no Author found");
        }
        return bookDao.saveAndFlush(book);
    }



    @Override
    public void deleteBook(int id) {
        if( !bookDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no Book found");
        }
        bookDao.deleteById(id);
    }

    @Override
    public String getBookByTitle(String title) {
        return title;
    }


    @Override
    public Book getBookById(int id) {
        return bookDao.findById(id).orElseThrow(()->
                new ResponseStatusException
                        (HttpStatus.BAD_REQUEST, " No Book with id"+ id));
    }
}

