package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.ru.netology.ProductManager;

class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Product(1, "product1",10);
    Product product2 = new Product(2,"product2",500);
    Product product3 = new Product(3, "product3", 1000);
    Product product4 = new Product(4, "product4", 222);
    Product product5 = new Product(5,"product5", 1732);

    Product book1 = new Book(1,"name1", 333,"author1");
    Product book2 = new Book(2, "name2", 888, "author2");
    Product book3 = new Book(3, "name3", 1000,"author3");
    Product book4 = new Book(4, "name4",235,"author4");
    Product book5 = new Book(5, "name5", 777,"author5");

    Product smartphone1 = new Smartphone(1,"phone1",222,"factory1");
    Product smartphone2 = new Smartphone(2,"phone2", 450,"factory2");
    Product smartphone3 = new Smartphone(3, "phone3", 130,"factory3");
    Product smartphone4 = new Smartphone(4,"phone4", 700,"factory4");
    Product smartphone5 = new Smartphone(5, "phone5", 800, "factory5");
    @BeforeEach
    public void setup(){
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);
    }
@Test
    public void shouldSearchByText(){
        Product[] expected = {book4};
        Product[] actual = manager.searchBy( "author4");
    Assertions.assertArrayEquals(expected,actual);
}

@Test
    public void shouldCheckIfProductMatches(){
        boolean expected = true;
        boolean actual = manager.matches(smartphone5,"phone");
        Assertions.assertEquals(expected,actual);
}


}