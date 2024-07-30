package Microservice.Billing_Service.dto;

public class SubscriptionData {

	private Long subtypeNumber;
	private String pricingRoutine;
	private String frequency;
	
	public SubscriptionData() {
	}
	public Long getSubtypeNumber() {
		return subtypeNumber;
	}
	public void setSubtypeNumber(Long subtypeNumber) {
		this.subtypeNumber = subtypeNumber;
	}
	public String getPricingRoutine() {
		return pricingRoutine;
	}
	public void setPricingRoutine(String pricingRoutine) {
		this.pricingRoutine = pricingRoutine;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "SubscriptionData{" +
				"subtypeNumber=" + subtypeNumber +
				", pricingRoutine='" + pricingRoutine + '\'' +
				", frequency='" + frequency + '\'' +
				'}';
	}
	
}
