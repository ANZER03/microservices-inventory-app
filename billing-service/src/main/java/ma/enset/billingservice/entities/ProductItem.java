package ma.enset.billingservice.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import ma.enset.billingservice.models.Product;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ProductItem {

    @Id @GeneratedValue
    private Long id;
    private Long productId;
    private Long quantity;
    private double price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "billing_id")
    private Bill bill;

    @Transient
    private Product product;
}
