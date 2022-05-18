package com.assignment.multipledatabases.service.book;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookService<T> {
    List<T> getAllBooks();
    T getBookById(Integer id);
    void saveBook(T book);
    void deleteBookById(Integer id);
}
