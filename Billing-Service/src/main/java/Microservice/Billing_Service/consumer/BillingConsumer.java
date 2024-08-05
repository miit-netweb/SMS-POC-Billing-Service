package Microservice.Billing_Service.consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Microservice.Billing_Service.Entity.BillingPending;
import Microservice.Billing_Service.Entity.BillingSuccess;
import Microservice.Billing_Service.Entity.Subscriber;
import Microservice.Billing_Service.Repository.SubscriberRepository;
import Microservice.Billing_Service.dto.PaymentLinkResponse;
import Microservice.Billing_Service.service.BillingService;
import Microservice.Billing_Service.service.RazorpayService;

@Service
public class BillingConsumer {

    @Autowired
    private BillingService billingService;

    @Autowired
    private RazorpayService razorpayService;

    @Autowired
    private SubscriberRepository subscriberRepo;
    
   private String subscriptionBillingDtoStr;

    @KafkaListener(topics = "billing", groupId = "billingGroup")
    public void consume(String subscriptionBillingDtoStr) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        
        this.subscriptionBillingDtoStr=subscriptionBillingDtoStr;

        try {
            BillingPending billingPending = objectMapper.readValue(subscriptionBillingDtoStr, BillingPending.class);
            //System.out.println(billingPending.getId());

            // RazorPay RequestBody Preparation
            Optional<Subscriber> optionalResponse = subscriberRepo.findSubscriberBySubscriberNumber(billingPending.getSubscriberNumber());
            if (optionalResponse.isPresent()) {
                Subscriber subscriber = optionalResponse.get();
                Map<String, Object> requestBody = new HashMap<>();
                requestBody.put("amount", 10000);
                requestBody.put("currency", "INR");
                requestBody.put("reference_id", UUID.randomUUID().toString().replace("-", "").substring(0, 5));
                requestBody.put("description", "Payment for Subscription of Subscriber: " + billingPending.getSubscriberNumber());

                Map<String, String> customer = new HashMap<>();
                customer.put("name", subscriber.getPersonalDetails().getFirstName() + " " + subscriber.getPersonalDetails().getLastName());
                customer.put("contact", subscriber.getPersonalDetails().getPhoneNumber().toString());
                customer.put("email", subscriber.getPersonalDetails().getEmail());

                requestBody.put("customer", customer);
                requestBody.put("callback_url", "http://localhost:8600/callback");
                requestBody.put("callback_method", "get");

                // Create payment link
                try {
                    String paymentLink = razorpayService.createPaymentLink(requestBody);
                    PaymentLinkResponse response = objectMapper.readValue(paymentLink, PaymentLinkResponse.class);
                    System.out.println("Callback URL: " + response.getCallbackUrl());
                    System.out.println("Short URL: " + response.getShortUrl());
                } catch (Exception e) {
                    e.printStackTrace();
                }

//                billingService.removePendingEntry(billingPending);
//                billingPending.setStatus("BILLING_SUCCESS");
//                billingService.addSuccessEntry(new BillingSuccess(
//                        billingPending.getSubscriberNumber(),
//                        billingPending.getPartnerNumber(),
//                        billingPending.getSubtypeNumber(),
//                        billingPending.getPricingRoutine(),
//                        "BILLING_SUCCESS"
//                ));
            } else {
                System.err.println("Subscriber not found: " );//+ billingPending.getSubscriberNumber());
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    
    public String insertSuccess() throws JsonMappingException, JsonProcessingException {
    	ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        
        try {
        BillingPending billingPending = objectMapper.readValue(subscriptionBillingDtoStr, BillingPending.class);
        System.out.println(billingPending.getId());
        
        billingService.removePendingEntry(billingPending);
        billingPending.setStatus("BILLING_SUCCESS");
        billingService.addSuccessEntry(new BillingSuccess(
                billingPending.getSubscriberNumber(),
                billingPending.getPartnerNumber(),
                billingPending.getSubtypeNumber(),
                billingPending.getPricingRoutine(),
                "BILLING_SUCCESS"
        ));
        }catch(Exception e) {
        	e.printStackTrace();
        }
		return "Inserted Successfully";
    }
}
