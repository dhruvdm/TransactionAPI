package util;

import com.xbank.txnapi.model.db.Transaction;
import com.xbank.txnapi.model.rest.CreateTransactionRequest;
import com.xbank.txnapi.model.rest.TransactionResponse;

public class ServiceUtil {

    public static TransactionResponse getResponseEntity(Transaction txn, String accountType) {

        TransactionResponse txnReq = new TransactionResponse();

        txnReq.setDate(DateUtil.getFormattedDateString(txn.getDateTime())); //Format the date

        txnReq.setAccountNumber(txn.getAccountNumber());
        txnReq.setAccountType(accountType);
        txnReq.setAmount(txn.getAmount());
        txnReq.setCurrencyCode(txn.getCurrencyCode());
        txnReq.setType(txn.getType());
        txnReq.setNarrative(txn.getNarrative());

        return txnReq;
    }

    public static Transaction getTransactionEntity(CreateTransactionRequest treq) {

        Transaction txn = new Transaction();

        txn.setAccountNumber(treq.getAccountNumber());
        txn.setAmount(treq.getAmount());
        txn.setCurrencyCode(treq.getCurrencyCode());
        txn.setDateTime(DateUtil.getDateFromString(treq.getDate()));
        txn.setType(treq.getType());
        txn.setNarrative(treq.getNarrative());
        return txn;
    }

}
