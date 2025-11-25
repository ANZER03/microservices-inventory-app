package ma.enset.billingservice.repositories;

import ma.enset.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "billings", collectionResourceRel = "billings")
public interface BillingRepository extends JpaRepository<Bill, Long> {

}
