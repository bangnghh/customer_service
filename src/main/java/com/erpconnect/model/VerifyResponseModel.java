package com.erpconnect.model;

public class VerifyResponseModel {
    private String error_code;
    private String error_message;
    private String transact_ref;
    private String bank_id;
    private String customer_id;
    private String debit_acc_id;
    private int debit_balance;
    private String credit_acc_id;
    private int transact_amount;
    private String currency;
    private String transact_message;
    private String signature;

    public VerifyResponseModel() {
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public String getTransact_ref() {
        return transact_ref;
    }

    public void setTransact_ref(String transact_ref) {
        this.transact_ref = transact_ref;
    }

    public String getBank_id() {
        return bank_id;
    }

    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getDebit_acc_id() {
        return debit_acc_id;
    }

    public void setDebit_acc_id(String debit_acc_id) {
        this.debit_acc_id = debit_acc_id;
    }

    public int getDebit_balance() {
        return debit_balance;
    }

    public void setDebit_balance(int debit_balance) {
        this.debit_balance = debit_balance;
    }

    public String getCredit_acc_id() {
        return credit_acc_id;
    }

    public void setCredit_acc_id(String credit_acc_id) {
        this.credit_acc_id = credit_acc_id;
    }

    public int getTransact_amount() {
        return transact_amount;
    }

    public void setTransact_amount(int transact_amount) {
        this.transact_amount = transact_amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTransact_message() {
        return transact_message;
    }

    public void setTransact_message(String transact_message) {
        this.transact_message = transact_message;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
