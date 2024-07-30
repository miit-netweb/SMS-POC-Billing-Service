package Microservice.Billing_Service.Repository;

import Microservice.Billing_Service.Entity.BillingSuccess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingSuccessRepository extends JpaRepository<BillingSuccess,Long> {
}
