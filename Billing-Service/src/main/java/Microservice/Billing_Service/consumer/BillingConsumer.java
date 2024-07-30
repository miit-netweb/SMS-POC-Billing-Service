package Microservice.Billing_Service.consumer;

import Microservice.Billing_Service.dto.SubscriptionBillingDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BillingConsumer {

    @KafkaListener(topics = "billing",groupId = "billingGroup")
    public void consume(String subscriptionBillingDtoStr){
        System.out.println("INSIDE CONSUMER : ");
        System.out.println(subscriptionBillingDtoStr);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        try {
            SubscriptionBillingDto subscriptionBillingDto = objectMapper.readValue(subscriptionBillingDtoStr, SubscriptionBillingDto.class);

            System.out.println("FINAL CONSUMED OBJECT  : ");
            System.out.println(subscriptionBillingDto.toString());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            }
        }

}

