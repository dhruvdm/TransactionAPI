package com.xbank.txnapi.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xbank.txnapi.model.TransactionType;
import com.xbank.txnapi.model.db.Transaction;
import com.xbank.txnapi.model.rest.AccountTypeRequest;
import com.xbank.txnapi.model.rest.TransactionResponse;
import com.xbank.txnapi.repository.TransactionRepository;

import util.DateUtil;
import util.ServiceUtil;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository repository;

    @Autowired
    RestTemplate restTemplate;

    @Value("${account.service.url}")
    private String acctServiceURL;

    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    public List<TransactionResponse> getTransactions(String accountNumber) {

        final String accountType = getAccountTypeFromAccountService(accountNumber);

        List<TransactionResponse> response = repository.findByAccountNumber(accountNumber).stream()
            .map(o -> ServiceUtil.getResponseEntity(o, accountType))
            .collect(Collectors.toList());

        return response;

    }

    private String getAccountTypeFromAccountService(String accountNumber) {

        try {
            ResponseEntity<String> acctTypeResponse = restTemplate.postForEntity(acctServiceURL,
                new AccountTypeRequest(accountNumber),
                String.class);

            if (acctTypeResponse.getStatusCode() == HttpStatus.OK) {
                return acctTypeResponse.getBody();
            } else {
                logger.warn("Account service responded with code : " + acctTypeResponse.getStatusCode());
                return "";
            }
        } catch (Exception ex) {
            logger.warn("Error while invoking account service." + ex.getMessage());
            return "";
        }

    }

    public void populateDummyData() {

        Transaction t;

        t = repository.save(new Transaction("11220000001",
            DateUtil.getDateFromString("2020-04-12T00:00:00.123+05:30"), new BigDecimal(45600000), "AUD",
            TransactionType.CREDIT, "test"));

        logger.info("New transaction: " + t.toString());

        t = repository.save(new Transaction("11220000001",
            DateUtil.getDateFromString("2020-04-13T00:00:00.123+05:30"), new BigDecimal(45600000), "AUD",
            TransactionType.DEBIT, "test"));

        logger.info("New transaction: " + t.toString());

        t = repository.save(new Transaction("11220000001",
            DateUtil.getDateFromString("2020-04-14T00:00:00.123+05:30"), new BigDecimal(45600000), "AUD",
            TransactionType.CREDIT, "test"));

        logger.info("New transaction: " + t.toString());

        t = repository.save(new Transaction("11220000002",
            DateUtil.getDateFromString("2020-04-15T00:00:00.123+05:30"), new BigDecimal(45600000), "AUD",
            TransactionType.CREDIT, "test"));

        logger.info("New transaction: " + t.toString());

        t = repository.save(new Transaction("11220000002",
            DateUtil.getDateFromString("2020-04-16T00:00:00.123+05:30"), new BigDecimal(45600000), "AUD",
            TransactionType.DEBIT, "test"));

        logger.info("New transaction: " + t.toString());

        t = repository.save(new Transaction("11220000002",
            DateUtil.getDateFromString("2020-04-17T00:00:00.123+05:30"), new BigDecimal(45600000), "AUD",
            TransactionType.CREDIT, "test"));

        logger.info("New transaction: " + t.toString());
    }
}
