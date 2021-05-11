package com.xbank.txnapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xbank.accountapi.model.rest.GetAccountByCustomerId;
import com.xbank.txnapi.model.rest.GetTransactionRequest;
import com.xbank.txnapi.model.rest.TransactionResponse;
import com.xbank.txnapi.service.TransactionService;

@RestController
@RequestMapping("/accounts")
public class TransactionApiController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transactions")
    public List<TransactionResponse> getTransactionsForAccount(@RequestBody GetTransactionRequest requestObject) {

        //Call AccountService to get account type

        return transactionService.getTransactions(requestObject.getAccountNumber());
    }

    /*
     * Dummy endpoint. Created to test the application with data. This will populate dummy data in the repo
     */
    @GetMapping("/transactions/createData")
    public void createDummyData() {

        transactionService.populateDummyData();

    }
}
