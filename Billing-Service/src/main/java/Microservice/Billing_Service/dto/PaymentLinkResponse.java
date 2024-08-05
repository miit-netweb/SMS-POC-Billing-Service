package Microservice.Billing_Service.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentLinkResponse {

	@JsonProperty("accept_partial")
	private boolean acceptPartial;

	private int amount;

	@JsonProperty("amount_paid")
	private int amountPaid;

	@JsonProperty("callback_method")
	private String callbackMethod;

	@JsonProperty("callback_url")
	private String callbackUrl;

	@JsonProperty("cancelled_at")
	private int cancelledAt;

	@JsonProperty("created_at")
	private long createdAt;

	private String currency;

	private Customer customer;

	private String description;

	@JsonProperty("expire_by")
	private long expireBy;

	@JsonProperty("expired_at")
	private int expiredAt;

	@JsonProperty("first_min_partial_amount")
	private int firstMinPartialAmount;

	private String id;

	private List<String> notes;

	private List<String> payments;

	@JsonProperty("reference_id")
	private String referenceId;

	@JsonProperty("reminder_enable")
	private boolean reminderEnable;

	private List<String> reminders;

	@JsonProperty("short_url")
	private String shortUrl;

	private String status;

	@JsonProperty("updated_at")
	private long updatedAt;

	@JsonProperty("upi_link")
	private boolean upiLink;

	@JsonProperty("user_id")
	private String userId;

	@JsonProperty("whatsapp_link")
	private boolean whatsappLink;

	public boolean isAcceptPartial() {
		return acceptPartial;
	}

	public void setAcceptPartial(boolean acceptPartial) {
		this.acceptPartial = acceptPartial;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getCallbackMethod() {
		return callbackMethod;
	}

	public void setCallbackMethod(String callbackMethod) {
		this.callbackMethod = callbackMethod;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public int getCancelledAt() {
		return cancelledAt;
	}

	public void setCancelledAt(int cancelledAt) {
		this.cancelledAt = cancelledAt;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getExpireBy() {
		return expireBy;
	}

	public void setExpireBy(long expireBy) {
		this.expireBy = expireBy;
	}

	public int getExpiredAt() {
		return expiredAt;
	}

	public void setExpiredAt(int expiredAt) {
		this.expiredAt = expiredAt;
	}

	public int getFirstMinPartialAmount() {
		return firstMinPartialAmount;
	}

	public void setFirstMinPartialAmount(int firstMinPartialAmount) {
		this.firstMinPartialAmount = firstMinPartialAmount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getNotes() {
		return notes;
	}

	public void setNotes(List<String> notes) {
		this.notes = notes;
	}

	public List<String> getPayments() {
		return payments;
	}

	public void setPayments(List<String> payments) {
		this.payments = payments;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public boolean isReminderEnable() {
		return reminderEnable;
	}

	public void setReminderEnable(boolean reminderEnable) {
		this.reminderEnable = reminderEnable;
	}

	public List<String> getReminders() {
		return reminders;
	}

	public void setReminders(List<String> reminders) {
		this.reminders = reminders;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(long updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isUpiLink() {
		return upiLink;
	}

	public void setUpiLink(boolean upiLink) {
		this.upiLink = upiLink;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isWhatsappLink() {
		return whatsappLink;
	}

	public void setWhatsappLink(boolean whatsappLink) {
		this.whatsappLink = whatsappLink;
	}
	
	
}
