package ma.enset.inventoryservice;

import ma.enset.inventoryservice.entities.Product;
import ma.enset.inventoryservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Autowired
    ProductRepository productRepository;

    @Bean
    CommandLineRunner runner() {
        return args -> {
            ArrayList<Product> products = new ArrayList<>();
            products.add(Product.builder().name("Phone").price(699.99).quantity(50).build());
            products.add(Product.builder().name("Laptop").price(1299.99).quantity(30).build());
            products.add(Product.builder().name("Tablet").price(499.99).quantity(40).build());
            products.add(Product.builder().name("Headphones").price(199.99).quantity(100).build());
            products.add(Product.builder().name("Smartwatch").price(299.99).quantity(25).build());
            productRepository.saveAll(products);
        };
    }
}
