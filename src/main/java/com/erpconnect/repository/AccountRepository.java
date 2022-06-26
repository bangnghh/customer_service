package com.erpconnect.repository;

import com.erpconnect.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountEntity, String> {
    //List<AccountEntity> findAccountEntityByCustomer_id (String customer_id);

    @Query(value = "SELECT * FROM account WHERE customer_id = ?1", nativeQuery = true)
    List<AccountEntity> findAllAccountByCustomerId(String customer_id);
}
