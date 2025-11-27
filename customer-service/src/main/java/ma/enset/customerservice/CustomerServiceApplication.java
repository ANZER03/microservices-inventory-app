package ma.enset.customerservice;

import ma.enset.customerservice.entities.Customer;
import ma.enset.customerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {
    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Autowired
    CustomerRepository customerRepository;

    @Bean
    CommandLineRunner runner() {
        return args -> {
            new Customer();
            customerRepository.save(Customer.builder()
                    .email("an@gmail.com")
                    .name("Anoir")
                    .build());
        };
    }
}
