package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
import ru.netology.ru.netology.ProductManager;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Product(1, "product1", 10);
    Product product2 = new Product(2, "product2", 500);
    Product product3 = new Product(3, "product3", 1000);
    Product product4 = new Product(4, "product4", 222);
    Product product5 = new Product(5, "product5", 1732);

    Product book1 = new Book(6, "name1", 333, "author1");
    Product book2 = new Book(7, "name2", 888, "author2");
    Product book3 = new Book(8, "name3", 1000, "author3");
    Product book4 = new Book(9, "name4", 235, "author4");
    Product book5 = new Book(10, "name5", 777, "author5");

    Product smartphone1 = new Smartphone(11, "phone1", 222, "factory1");
    Product smartphone2 = new Smartphone(12, "phone2", 450, "factory2");
    Product smartphone3 = new Smartphone(13, "phone3", 130, "factory3");
    Product smartphone4 = new Smartphone(14, "phone4", 700, "factory4");
    Product smartphone5 = new Smartphone(15, "phone5", 800, "factory5");

    @BeforeEach
    public void setup() {
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
    public void shouldSearchByText() {
        Product[] expected = {product1};
        Product[] actual = manager.searchBy("product1");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckIfProductMatches() {
        boolean expected = true;
        boolean actual = smartphone5.matches("phone");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdTest() {
        repo.removeById(smartphone3.getId());
        Product[] expected = {product1, product2, product3, product4, product5, book1, book2, book3, book4, book5, smartphone1, smartphone2, smartphone4, smartphone5};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameTest() {
        Product[] expected = {product1};
        Product[] actual = manager.searchBy("product1");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthorTest() {
        Product[] expected = {book3};
        Product[] actual = manager.searchBy("author3");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchByFactoryTest() {
        Product[] expected = {smartphone4};
        Product[] actual = manager.searchBy("factory4");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookByNameTest() {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("name2");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductByNameTest() {
        Product[] expected = {product1};
        Product[] actual = manager.searchBy("product1");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByNameTest() {
        Product[] expected = {smartphone4};
        Product[] actual = manager.searchBy("phone4");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNewWay() {
        repo.removeById(product1.getId());
        Product[] expected = {product2, product3, product4, product5, book1, book2, book3, book4, book5, smartphone1, smartphone2, smartphone3, smartphone4, smartphone5};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindIdByNewWay() {
        Assertions.assertThrows(NotFoundException.class,
                () -> {
                    repo.removeById(17);
                });
    }

    @Test
    public void shouldSaveByNewWay() {
        Product smartphone6 = new Smartphone(16, "phone6", 999, "factory6");
        repo.save(smartphone6);
        Product[] expected = {product1, product2, product3, product4, product5, book1, book2, book3, book4, book5, smartphone1, smartphone2, smartphone3, smartphone4, smartphone5, smartphone6};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchRepeatedId() {
        Product smartphone6 = new Smartphone(15, "phone6", 999, "factory6");
        Assertions.assertThrows(AlreadyExistsException.class,
                () -> {
                    repo.save(smartphone6);
                });
    }

}
