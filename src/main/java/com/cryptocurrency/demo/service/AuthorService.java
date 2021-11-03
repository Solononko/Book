package com.cryptocurrency.demo.service;

import com.cryptocurrency.demo.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();

    Author  getAuthorById(int id);

    Author createAuthor(Author author);

    Author updateAuthor(int id, Author author);

    void deleteAuthor(int id);
}
