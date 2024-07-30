package Microservice.Billing_Service.consumer;

import Microservice.Billing_Service.Entity.BillingPending;
import Microservice.Billing_Service.Entity.BillingSuccess;
import Microservice.Billing_Service.service.BillingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BillingConsumer {

    @Autowired
    private BillingService billingService;

    @KafkaListener(topics = "billing",groupId = "billingGroup")
    public void consume(String subscriptionBillingDtoStr){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        try {

            BillingPending billingPending = objectMapper.readValue(subscriptionBillingDtoStr, BillingPending.class);
            System.out.println(billingPending.getId());
            billingService.removePendingEntry(billingPending);
            billingPending.setStatus("BILLING_SUCCESS");
            billingService.addSuccessEntry(new BillingSuccess(billingPending.getSubscriberNumber(),billingPending.getPartnerNumber(),billingPending.getSubtypeNumber(),billingPending.getPricingRoutine(),"BILLING_SUCCESS"));

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            }
        }

}

