package com.banking.demo4.Repository;

import com.banking.demo4.Entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository  extends JpaRepository<Transfer,Long> {

    List<Transfer>findByUserId(String username);
}
