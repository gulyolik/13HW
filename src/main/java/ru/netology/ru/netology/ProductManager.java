package ru.netology.ru.netology;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repo;


    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product products) {
        repo.save(products);
    }

    public void getProducts() {

        repo.findAll();
    }


    public Product[] searchBy(String text) {
        int amount = 0;
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }

            return result;
        }


        public boolean matches (Product product, String search){
            return product.getName().contains(search);
        }
}

