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
public class Transfer {
    @Id
    @SequenceGenerator(name = "transfer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "transfer_sequence")
    Long transferId;
    Long accountHolder;
    Long beneficiaryAccount;
    String reference;
    Double amount;
    String userId;
    LocalDateTime localDateTime;


}
