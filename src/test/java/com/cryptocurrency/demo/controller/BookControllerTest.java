//package com.cryptocurrency.demo.controller;
//
//import com.cryptocurrency.demo.entity.Author;
//import com.cryptocurrency.demo.entity.Book;
//import com.cryptocurrency.demo.service.BookService;
//import org.hamcrest.CoreMatchers;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//@WebMvcTest(BookController.class)
//@ExtendWith(SpringExtension.class)
//public class BookControllerTest {
//    @Mock
//    private BookService bookService;
//@Autowired
//    private MockMvc mockMvc;
//@Test
//    public void givenTitleWhenGettingBookThenReturnBook(){
//    Mockito.when(bookService.getBookByTitle(ArgumentMatchers.anyString()))
//            .thenReturn(new Book(1, "Avengers",12,new Author()));
//    mockMvc.perform(MockMvcRequestBuilders.get("/book/title/{title}")
//                    .param("title","Avengers")).andExpect(MockMvcResultMatchers.status().isOk())
//            .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(1)))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.title", CoreMatchers.is("Avengers")));
//}
//}
