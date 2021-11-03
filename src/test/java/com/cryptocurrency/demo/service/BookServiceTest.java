package com.cryptocurrency.demo.service;

import com.cryptocurrency.demo.dao.BookDao;
import com.cryptocurrency.demo.dto.BookCreateDto;
import com.cryptocurrency.demo.dto.BookDto;
import com.cryptocurrency.demo.dto.BookPage;
import com.cryptocurrency.demo.entity.Author;
import com.cryptocurrency.demo.entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
private BookDao bookDao;
    @Mock
private AuthorService authorService;
    @InjectMocks
    private BookServiceImpl bookService;
    @Test
    public void givenPageAndSizeWhenGettingBooksThenReturnBooks(){
       List<Book> books= new ArrayList<>(10);
        books.add(new Book(1, "Hello", 12,generateAuthor(1)));
       books.add(new Book(2, "Word", 123,generateAuthor(2)));
         final PageImpl<Book> booksPage = new PageImpl<>(books);
        Mockito.when(bookDao.findAll(ArgumentMatchers.
                any(PageRequest.class)))
                .thenReturn(booksPage);
//        new PageImpl<Book>(books);
        List<BookDto> bookDtos = new ArrayList<>();
        final BookDto bookDto1 =new BookDto();
        bookDto1.setBookId(1);
        bookDto1.setPrice(12);
        bookDto1.setAuthorId(1);
        final BookDto bookDto2 =new BookDto();
        bookDto2.setBookId(2);
        bookDto2.setPrice(123);
        bookDto2.setAuthorId(1);
        bookDtos.add(bookDto1);
        bookDtos.add(bookDto2);

        BookPage expectedResult = new BookPage();
        expectedResult.setBooks(bookDtos);
        expectedResult.setTotalElement(2);

       final BookPage actualResult = bookService.getAllBooks(0, 1);
//        Assertions.assertEquals(expectedResult.getTotalElement(),
//                actualResult.getTotalElement());
        Assertions.assertEquals(expectedResult.getBooks().get(0).getBookId(),
                actualResult.getBooks().get(0).getBookId());
    }
    @Test
    public void givenTitleStartingWithSmallLatterWhenSavingBookThenThrowException(){
        BookCreateDto book = new BookCreateDto();
        book.setTitle("ou");
        Assertions.assertThrows(ResponseStatusException.class,()->bookService.
                createBook(book));
    }

    private Author generateAuthor(int id){
        return new Author(id, "Tarantino", null,null);
    }
}
