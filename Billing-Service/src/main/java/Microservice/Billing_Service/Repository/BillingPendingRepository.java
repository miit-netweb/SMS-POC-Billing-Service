package Microservice.Billing_Service.Repository;

import Microservice.Billing_Service.Entity.BillingPending;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingPendingRepository extends JpaRepository<BillingPending,Long> {
}
