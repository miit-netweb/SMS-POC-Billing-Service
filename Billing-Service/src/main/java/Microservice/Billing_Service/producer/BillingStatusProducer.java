package Microservice.Billing_Service.producer;

import Microservice.Billing_Service.dto.BillingStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BillingStatusProducer {

    private KafkaTemplate<String, BillingStatus> kafkaTemplate;
    private final Logger LOGGER = LoggerFactory.getLogger(BillingStatus.class);

    public BillingStatusProducer(KafkaTemplate<String, BillingStatus> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(BillingStatus billingStatus){
        kafkaTemplate.send("billing-status",billingStatus);
    }

}

