package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Book extends Product{
    public String getAuthor() {
        return author;
    }

    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)){
            return true;
        } else{
            return getAuthor().contains(search);
        }
    }
}
