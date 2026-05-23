package com.example.bookmyshow_v1.models;

import com.example.bookmyshow_v1.models.Enums.PaymentMode;
import com.example.bookmyshow_v1.models.Enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Payment extends BaseModel{

    private int amount;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

    @OneToOne
    private Ticket ticket;

    private String transactionId;
}
