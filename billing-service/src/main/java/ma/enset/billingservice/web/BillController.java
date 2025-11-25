package ma.enset.billingservice.web;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.enset.billingservice.entities.Bill;
import ma.enset.billingservice.feign.CustomerServiceRestClient;
import ma.enset.billingservice.feign.InventoryServiceRestClient;
import ma.enset.billingservice.models.Customer;
import ma.enset.billingservice.models.Product;
import ma.enset.billingservice.repositories.BillingRepository;
import ma.enset.billingservice.repositories.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bills")
public class BillController {
    @Autowired
    private BillingRepository billingRepository;
    @Autowired
    private CustomerServiceRestClient customerServiceRestClient;
    @Autowired
    private InventoryServiceRestClient inventoryServiceRestClient;
    @Autowired
    private ProductItemRepository productItemRepository;

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id){
        Bill bill=billingRepository.findById(id).orElseThrow(() -> new RuntimeException("Bill not found"));
        Customer c = customerServiceRestClient.findCustomerById(bill.getCustomerId());
        bill.getProductItems().forEach(
                pi -> {
                    Product p = inventoryServiceRestClient.findProductById(pi.getProductId());
                    pi.setProduct(p);
                }
        );
        bill.setCustomer(c);
        return bill;
    }

}
