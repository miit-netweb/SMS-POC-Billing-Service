package Microservice.Billing_Service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    @GetMapping("/callback")
    public String callback(
            @RequestParam("razorpay_payment_id") String paymentId,
            @RequestParam("razorpay_payment_link_id") String paymentLinkId,
            @RequestParam("razorpay_payment_link_reference_id") String paymentLinkReferenceId,
            @RequestParam("razorpay_payment_link_status") String paymentLinkStatus,
            @RequestParam("razorpay_signature") String signature) {
        
        // Log the received parameters (for debugging purposes)
        LOGGER.info("Payment ID: {}" +
                "Payment Link ID : {}" +
                "Payment Link Reference ID : {}" +
                "Payment Link Status : {}" +
                "Signature : {}",
                paymentId, paymentLinkId, paymentLinkReferenceId, paymentLinkStatus, signature);

       try {
           LOGGER.info("Payment has been successfully done.");
    	   consumer.insertSuccess();
       }catch(Exception e) {
    	   LOGGER.error("Issue occurred while updating the entries in the database table : {}",e.getMessage());
       }
        
        // Call the service method to handle the business logic and save to DB
       // paymentService.handlePaymentCallback(paymentId, paymentLinkId, paymentLinkReferenceId, paymentLinkStatus, signature);

        return "Payment Done Successfully!";
    }
}

