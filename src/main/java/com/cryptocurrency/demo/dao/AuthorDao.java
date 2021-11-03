package com.cryptocurrency.demo.dao;

import com.cryptocurrency.demo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author,Integer > {
}
