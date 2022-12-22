package ru.netology.repository;

import ru.netology.domain.Book;
import ru.netology.domain.Product;

public class ProductRepository {
   private Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public void save(Product product){
       Product[] tmp = new Product[products.length+1];
       for(int i = 0; i<products.length; i++){
           tmp[i] = product;
       }
       tmp[tmp.length-1] = product;
       products = tmp;
   }

   public void removeById(int id){
       Product[] tmp = new Product[products.length-1];
       int copyToIndex = 0;
       for(Product product: products){
           if(product.getId()!=id){
               copyToIndex++;
           }
       }
       products = tmp;
   }

}