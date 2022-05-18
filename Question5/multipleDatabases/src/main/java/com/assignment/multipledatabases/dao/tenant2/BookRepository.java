package com.assignment.multipledatabases.dao.tenant2;

import com.assignment.multipledatabases.entity.tenant2.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
