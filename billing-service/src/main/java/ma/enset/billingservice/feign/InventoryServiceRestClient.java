package ma.enset.billingservice.feign;


import ma.enset.billingservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface InventoryServiceRestClient {
    @GetMapping("/products/{id}")
    Product findProductById(@PathVariable Long id);

    @GetMapping("/products")
    List<Product> getAllProducts();
}
