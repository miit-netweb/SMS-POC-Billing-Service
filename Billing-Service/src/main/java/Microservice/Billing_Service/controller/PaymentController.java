package Microservice.Billing_Service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Microservice.Billing_Service.consumer.BillingConsumer;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentController {

	@Autowired
	private BillingConsumer consumer;

    @GetMapping("/callback")
    public String callback(
            @RequestParam("razorpay_payment_id") String paymentId,
            @RequestParam("razorpay_payment_link_id") String paymentLinkId,
            @RequestParam("razorpay_payment_link_reference_id") String paymentLinkReferenceId,
            @RequestParam("razorpay_payment_link_status") String paymentLinkStatus,
            @RequestParam("razorpay_signature") String signature) {
        
        // Log the received parameters (for debugging purposes)
        log.info("Payment ID: " + paymentId);
        log.info("Payment Link ID: " + paymentLinkId);
        log.info("Payment Link Reference ID: " + paymentLinkReferenceId);
        log.info("Payment Link Status: " + paymentLinkStatus);
        log.info("Signature: " + signature);

       try {
    	   consumer.insertSuccess();
       }catch(Exception e) {
    	   e.printStackTrace();
       }
        
        // Call the service method to handle the business logic and save to DB
       // paymentService.handlePaymentCallback(paymentId, paymentLinkId, paymentLinkReferenceId, paymentLinkStatus, signature);

        return "Payment Done Successfully!";
    }
}

