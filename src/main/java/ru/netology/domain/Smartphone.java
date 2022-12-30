package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Smartphone extends Product {
    private String factory;

    public Smartphone(int id, String name, int price, String factory) {
        super(id, name, price);
        this.factory = factory;
    }

}
