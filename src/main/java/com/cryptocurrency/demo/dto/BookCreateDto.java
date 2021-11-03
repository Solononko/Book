package com.cryptocurrency.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BookCreateDto {
    private int id;
    private String title;
    private int price;
    private int authorId;
}
