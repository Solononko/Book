package com.cryptocurrency.demo.dto;

import com.cryptocurrency.demo.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookPage {
    private List<BookDto> books;
    private long totalElement;
    private int currentPage;
    private boolean last;
}
