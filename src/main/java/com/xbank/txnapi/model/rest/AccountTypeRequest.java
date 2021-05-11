package com.xbank.txnapi.model.rest;

public class AccountTypeRequest {

    String accountNumber;

    public AccountTypeRequest() {
        super();
    }

    public AccountTypeRequest(String accountNumber) {
        super();
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

}
