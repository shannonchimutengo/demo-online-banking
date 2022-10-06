package com.banking.demo4.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Payment {
    @Id
    @SequenceGenerator(name = "payment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "payment_sequence")
    Long paymentId;
    Long accountHolder;
    Long beneficiaryAccount;
    String reference;
    Double amount;
    LocalDateTime localDateTime;
    String userId;
}
