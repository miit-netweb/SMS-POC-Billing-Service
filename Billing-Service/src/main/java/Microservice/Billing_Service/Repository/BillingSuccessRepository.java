package Microservice.Billing_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Microservice.Billing_Service.Entity.BillingSuccess;

public interface BillingSuccessRepository extends JpaRepository<BillingSuccess,Long> {
}
