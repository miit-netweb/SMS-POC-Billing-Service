package Microservice.Billing_Service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Microservice.Billing_Service.Entity.BillingPending;
import Microservice.Billing_Service.Entity.BillingSuccess;
import Microservice.Billing_Service.Repository.BillingPendingRepository;
import Microservice.Billing_Service.Repository.BillingSuccessRepository;

@Service
public class BillingService {

    @Autowired
    private BillingPendingRepository billingPendingRepository;
    @Autowired
    private BillingSuccessRepository billingSuccessRepository;

    public void removePendingEntry(BillingPending billingPending){
        billingPendingRepository.delete(billingPending);
    }

    public BillingSuccess addSuccessEntry(BillingSuccess billingSuccess){
        return billingSuccessRepository.save(billingSuccess);
    }

}
