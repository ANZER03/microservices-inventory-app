package ma.enset.billingservice.cli;

import ma.enset.billingservice.entities.Bill;
import ma.enset.billingservice.entities.ProductItem;
import ma.enset.billingservice.feign.InventoryServiceRestClient;
import ma.enset.billingservice.models.Product;
import ma.enset.billingservice.repositories.BillingRepository;
import ma.enset.billingservice.repositories.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CLI implements CommandLineRunner {
    final BillingRepository billingRepository;
    final ProductItemRepository productItemRepository;
    final InventoryServiceRestClient inventoryServiceRestClient;

    public CLI(BillingRepository billingRepository,
               ProductItemRepository productItemRepository,
               InventoryServiceRestClient inventoryServiceRestClient) {
        this.billingRepository = billingRepository;
        this.productItemRepository = productItemRepository;
        this.inventoryServiceRestClient = inventoryServiceRestClient;
    }

    @Override
    public void run(String... args) throws Exception {

        Bill billing = billingRepository.save(Bill.builder()
                .billingDate(new Date("2023/01/01"))
                .customerId(1L)
                .build());

        ProductItem save = productItemRepository.saveAndFlush(ProductItem.builder()
                .price(100.0)
                .bill(billing)
                .quantity(20L)
                .productId(1L)
                .build());

        ProductItem save2 = productItemRepository.saveAndFlush(ProductItem.builder()
                .price(100.0)
                .bill(billing)
                .quantity(20L)
                .productId(2L)
                .build());


        Bill b1 = billingRepository.findById(billing.getId()).orElseThrow(() -> new RuntimeException("Billing not found"));

        System.out.println(b1.getId() + " " + b1.getBillingDate() + " " + b1.getCustomerId());
        System.out.println("################");

        Product p = inventoryServiceRestClient.findProductById(1L);
        System.out.println(p.getName() + " " + p.getPrice() + " " + p.getQuantity());

//        List<Product> ps = inventoryServiceRestClient.getAllProducts();
//
//        ps.forEach(
//                pro -> {
//                    System.out.println(pro.getName() + " " + pro.getPrice() + " " + pro.getQuantity());
//                }
//        );

    }
}

