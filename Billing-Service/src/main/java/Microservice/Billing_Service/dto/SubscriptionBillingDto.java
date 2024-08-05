package Microservice.Billing_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionBillingDto {

    private String subscriberNumber;
    private long partnerNumber;
    private CardDetail cardDetail;
    private SubscriptionData subscriptionData;
}
