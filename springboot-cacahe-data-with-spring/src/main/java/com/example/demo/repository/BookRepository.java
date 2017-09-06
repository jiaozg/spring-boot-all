package com.example.demo.repository;

import com.example.demo.entity.Book;

/**
 * Created by jiaozhiguang on 2017/8/24.
 */
public interface BookRepository {
    Book getByIsbn(String isbn);
}
