package com.blibli.learnspringboot.model;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private String genre;

    @Column
    private Double borrowPrice;

    public Book() {
    }

    public Book(String name, String author, String genre, Double borrowPrice) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.borrowPrice = borrowPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getBorrowPrice() {
        return borrowPrice;
    }

    public void setBorrowPrice(Double borrowPrice) {
        this.borrowPrice = borrowPrice;
    }
}
