package ma.enset.billingservice.entities;


import jakarta.persistence.*;
import lombok.*;
import ma.enset.billingservice.models.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@NoArgsConstructor @AllArgsConstructor @Builder @Getter @Setter
public class Bill {

    @Id @GeneratedValue
    private Long id;
    private Long customerId;
    private Date billingDate;

    @OneToMany(mappedBy = "bill", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductItem> productItems = new ArrayList<>();

    @Transient
    private Customer customer;
}
