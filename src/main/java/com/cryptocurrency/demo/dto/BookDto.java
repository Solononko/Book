package com.cryptocurrency.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDto {
    private int bookId;
    private String title;
    private double price;
    private  int authorId;
}
