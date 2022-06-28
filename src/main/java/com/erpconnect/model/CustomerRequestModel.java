package com.erpconnect.model;

public class CustomerRequestModel {
    private String customer_id;
    private String password;
    private String first_password;
    private String customer_name;
    private String customer_address;
    private String customer_phone;
    private String customer_public_key;
    private String contact_email;
    private String contact_phone;
    private String document_path;

    public CustomerRequestModel() {
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_public_key() {
        return customer_public_key;
    }

    public void setCustomer_public_key(String customer_public_key) {
        this.customer_public_key = customer_public_key;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public String getDocument_path() {
        return document_path;
    }

    public void setDocument_path(String document_path) {
        this.document_path = document_path;
    }

    public String getFirst_password() {
        return first_password;
    }

    public void setFirst_password(String first_password) {
        this.first_password = first_password;
    }
}
