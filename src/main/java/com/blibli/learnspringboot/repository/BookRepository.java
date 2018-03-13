package com.blibli.learnspringboot.repository;

import com.blibli.learnspringboot.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Iterable<Book> findByNameContaining(String name);

}
