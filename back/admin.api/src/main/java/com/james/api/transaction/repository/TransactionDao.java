package com.james.api.transaction.repository;
import com.james.api.transaction.model.TransactionDto;
import java.util.List;
import java.util.Map;


public interface TransactionDao {

    Long countAllTransactions();

    List<TransactionDto> getAllTransactions();

    Map<String, Double> getTotalByDate();

    Map<String, Map<String, Integer>> getQuantityByDate();

    Long getTransactionsById();

    List<String> getTransactionsByUsername();

    Map<String, Double> getNetProfitByDate();

}
