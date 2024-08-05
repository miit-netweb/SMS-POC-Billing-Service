package Microservice.Billing_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionData {

	private Long subtypeNumber;
	private String pricingRoutine;
	private String frequency;
}
