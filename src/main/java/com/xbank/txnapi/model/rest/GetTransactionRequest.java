package com.xbank.txnapi.model.rest;

public class GetTransactionRequest {

    String accountNumber;

    public GetTransactionRequest() {
        super();
    }

    public GetTransactionRequest(String accountNumber) {
        super();
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "GetTransactionRequest [accountNumber=" + accountNumber + "]";
    }

}
