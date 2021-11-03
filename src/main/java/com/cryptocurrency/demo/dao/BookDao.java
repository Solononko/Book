package com.cryptocurrency.demo.dao;

import com.cryptocurrency.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book,Integer > {
}
