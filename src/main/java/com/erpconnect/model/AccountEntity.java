package com.erpconnect.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account", schema = "public", catalog = "masterdata")
public class AccountEntity {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "account_id")
    private String account_id;
    @Basic
    @Column(name = "customer_id")
    private String customer_id;
    @Basic
    @Column(name = "bank_id")
    private String bank_id;

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getBank_id() {
        return bank_id;
    }

    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity that = (AccountEntity) o;
        return Objects.equals(account_id, that.account_id) && Objects.equals(customer_id, that.customer_id) && Objects.equals(bank_id, that.bank_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account_id, customer_id, bank_id);
    }
}
