package com.banking.demo4.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Account {

    @Id
    @SequenceGenerator(name = "id_sequence", allocationSize = 1,initialValue = 1000000000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_sequence")
    Long account_number;
    String account_name;
    String account_type;
    LocalDateTime date_created;
    String userId;
    Double account_balance;

}
