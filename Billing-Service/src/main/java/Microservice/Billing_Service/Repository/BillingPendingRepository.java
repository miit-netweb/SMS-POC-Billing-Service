package Microservice.Billing_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Microservice.Billing_Service.Entity.BillingPending;

public interface BillingPendingRepository extends JpaRepository<BillingPending,Long> {
}
