package Microservice.Billing_Service.dto;

public class SubscriptionBillingDto {

    private String subscriberNumber;
    private long partnerNumber;
    private CardDetail cardDetail;
    private SubscriptionData subscriptionData;

    public SubscriptionBillingDto() {
    }

    public SubscriptionBillingDto(String subscriberNumber, long partnerNumber, CardDetail cardDetail, SubscriptionData subscriptionData) {
        this.subscriberNumber = subscriberNumber;
        this.partnerNumber = partnerNumber;
        this.cardDetail = cardDetail;
        this.subscriptionData = subscriptionData;
    }

    public String getSubscriberNumber() {
        return subscriberNumber;
    }

    public void setSubscriberNumber(String subscriberNumber) {
        this.subscriberNumber = subscriberNumber;
    }

    public long getPartnerNumber() {
        return partnerNumber;
    }

    public void setPartnerNumber(long partnerNumber) {
        this.partnerNumber = partnerNumber;
    }

    public CardDetail getCardDetail() {
        return cardDetail;
    }

    public void setCardDetail(CardDetail cardDetail) {
        this.cardDetail = cardDetail;
    }

    public SubscriptionData getSubscriptionData() {
        return subscriptionData;
    }

    public void setSubscriptionData(SubscriptionData subscriptionData) {
        this.subscriptionData = subscriptionData;
    }

    @Override
    public String toString() {
        return "SubscriptionBillingDto{" +
                "subscriberNumber='" + subscriberNumber + '\'' +
                ", partnerNumber=" + partnerNumber +
                ", cardDetail=" + cardDetail +
                ", subscriptionData=" + subscriptionData +
                '}';
    }
}
