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
@Builder
@Data

public class Withdrawal {

    @Id
            @SequenceGenerator(name = "withdrawal_sequence",initialValue = 1)
            @GeneratedValue(strategy = GenerationType.AUTO, generator = "withdrawal_sequence")
    Long withdrawalId;
    Long accountNumber;
    String reference;
    LocalDateTime localDateTime;
    Double amount;
    String userId;

}
