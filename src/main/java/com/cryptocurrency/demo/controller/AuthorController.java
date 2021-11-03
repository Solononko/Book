package com.cryptocurrency.demo.controller;

import com.cryptocurrency.demo.entity.Author;
import com.cryptocurrency.demo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/author")
public class AuthorController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthorController.class);
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable int id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author insertAuthor(@RequestBody @Valid Author author) {
        LOG.info("Handling post request for object{},", author);
        return authorService.createAuthor(author);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Author updateAuthor(@PathVariable int id, @RequestBody @Valid Author author) {
        return authorService.updateAuthor(id, author);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id) {
        authorService.deleteAuthor(id);
    }
}
