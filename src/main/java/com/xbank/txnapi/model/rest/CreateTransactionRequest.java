package com.xbank.txnapi.model.rest;

import java.math.BigDecimal;

import com.xbank.txnapi.model.TransactionType;

public class CreateTransactionRequest {

    String accountNumber;

    String accountType;

    String date;

    String currencyCode;

    BigDecimal amount;

    TransactionType type;

    String narrative;

    public CreateTransactionRequest() {
        super();
    }

    public CreateTransactionRequest(String accountNumber, String acctType, String date, String currencyCode,
        BigDecimal amount, TransactionType type, String narrative) {
        super();
        this.accountNumber = accountNumber;
        this.accountType = acctType;
        this.date = date;
        this.currencyCode = currencyCode;
        this.amount = amount;
        this.type = type;
        this.narrative = narrative;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    @Override
    public String toString() {
        return "TransactionResponseEntity [accountNumber=" + accountNumber + ", accountType=" + accountType + ", date="
            + date + ", currencyCode=" + currencyCode + ", amount=" + amount + ", type=" + type + ", narrative="
            + narrative + "]";
    }
}
