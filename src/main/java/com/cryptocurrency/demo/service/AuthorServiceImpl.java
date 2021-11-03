package com.cryptocurrency.demo.service;

import com.cryptocurrency.demo.dao.AuthorDao;
import com.cryptocurrency.demo.entity.Author;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.CharUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorDao authorDao;
    @Override
    public List<Author> getAllAuthors() {
        return authorDao.findAll();
    }

    @Override
    public Author createAuthor(Author author) {
        if(!CharUtils.isAsciiAlphaUpper(author.getName().charAt(0))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Title should start with capital letter");
        }
        return authorDao.saveAndFlush(author);
    }

    @Override
    public Author updateAuthor(int id, Author author) {
        author.setId(id);
        if( !authorDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no Author found");
        }
        return authorDao.saveAndFlush(author);
    }


    @Override
    public void deleteAuthor(int id) {
        if( !authorDao.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no Author found");
        }
        authorDao.deleteById(id);
    }

    @Override
    public Author getAuthorById(int id) {
        return authorDao.findById(id).orElseThrow(()->
                new ResponseStatusException
                        (HttpStatus.BAD_REQUEST, " No Author with id"+ id));
    }
}

