package Microservice.Billing_Service.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDetail {

    private String cardNumber;
    private String cardType;
    private String cardHolder;
    private LocalDate cardExpiry;
}