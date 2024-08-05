package Microservice.Billing_Service.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memID;
    @Column(unique = true)
    private String subscriberNumber;
    private long partnerNumber;
    private long subtypeNumber;
    @OneToOne(fetch = FetchType.EAGER)
    private PersonalDetails personalDetails;

    public Subscriber() {
    }

    public Subscriber(String subscriberNumber, long partnerNumber, long subtypeNumber, PersonalDetails personalDetails) {
        this.subscriberNumber = subscriberNumber;
        this.partnerNumber = partnerNumber;
        this.subtypeNumber = subtypeNumber;
        this.personalDetails = personalDetails;
    }

    public Long getMemID() {
        return memID;
    }

    public void setMemID(Long memID) {
        this.memID = memID;
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

    public long getSubtypeNumber() {
        return subtypeNumber;
    }

    public void setSubtypeNumber(long subtypeNumber) {
        this.subtypeNumber = subtypeNumber;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "memID=" + memID +
                ", subscriberNumber='" + subscriberNumber + '\'' +
                ", partnerNumber=" + partnerNumber +
                ", subtypeNumber=" + subtypeNumber +
                ", personalDetails=" + personalDetails +
                '}';
    }
}
