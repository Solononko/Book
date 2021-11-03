package com.cryptocurrency.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
    private String title;
    private double price;
    @ManyToOne
//    @JoinColumn(name = "author_id")
    @JsonIgnore
    private Author author;
}
