package com.xbank.txnapi.model.db;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xbank.txnapi.model.TransactionType;

@Entity
@Table(name = "txn")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column
    String accountNumber;

    @Column
    ZonedDateTime dateTime;

    @Column
    BigDecimal amount;

    @Column
    String currencyCode;

    @Column
    TransactionType type;

    @Column
    String narrative;

    public Transaction() {
    }

    public Transaction(String accountNumber, ZonedDateTime dateTime, BigDecimal amount,
        String currencyCode, TransactionType type, String narrative) {

        this.accountNumber = accountNumber;
        this.dateTime = dateTime;
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.type = type;
        this.narrative = narrative;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
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
        return "TransactionEntity [id=" + id + ", accountNumber=" + accountNumber + ", dateTime=" + dateTime
            + ", amount=" + amount + ", currencyCode=" + currencyCode + ", type=" + type + ", narrative=" + narrative
            + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
