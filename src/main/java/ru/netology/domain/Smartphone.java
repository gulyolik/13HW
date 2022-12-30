package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Smartphone extends Product {
    public String getFactory() {
        return factory;
    }

    private String factory;

    public Smartphone(int id, String name, int price, String factory) {
        super(id, name, price);
        this.factory = factory;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        } else {
            return getFactory().contains(search);
        }
    }
}


