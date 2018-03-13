package com.blibli.learnspringboot.controller;

import com.blibli.learnspringboot.model.Book;
import com.blibli.learnspringboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public @ResponseBody Iterable<Book> getAll () {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Book getById(
            @PathVariable("id") Long id
            ) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book = optionalBook.orElse(null);
        return book;
    }

    @GetMapping("/search")
    public @ResponseBody Iterable<Book> getByNameLike (
            @RequestParam("search") String search
            ) {
        Iterable<Book> books = bookRepository.findByNameContaining(search);
        return books;
    }

    @PostMapping("")
    public @ResponseBody Book store (
            @RequestParam("name") String name,
            @RequestParam("author") String author,
            @RequestParam("genre") String genre,
            @RequestParam("borrowPrice") Double borrowPrice
            ) {

        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setBorrowPrice(borrowPrice);
        bookRepository.save(book);

        return book;
    }

    @PutMapping("/{id}")
    public @ResponseBody Book edit (
            @PathVariable("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("author") String author,
            @RequestParam("genre") String genre,
            @RequestParam("borrowPrice") Double borrowPrice
            ) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book = optionalBook.orElse(null);
        if(null == book) return null;
        book.setName(name);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setBorrowPrice(borrowPrice);
        bookRepository.save(book);

        return book;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String destroy (
            @PathVariable("id") Long id
            ) {
        bookRepository.deleteById(id);
        return "Success";
    }

}
