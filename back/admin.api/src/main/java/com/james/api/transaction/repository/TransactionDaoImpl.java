package com.james.api.transaction.repository;


import com.james.api.transaction.model.QTransaction;
import com.james.api.transaction.model.QTransactionDto;
import com.james.api.transaction.model.TransactionDto;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class TransactionDaoImpl implements TransactionDao {

    private final QTransaction transaction = QTransaction.transaction;
    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public Long countAllTransactions() {
        return jpaQueryFactory.select(transaction.count())
                .from(transaction)
                .fetchFirst();
    }
    @Override
    public List<TransactionDto> getAllTransactions() {
        return jpaQueryFactory.select(
                        new QTransactionDto(
                                transaction.id,
                                transaction.username,
                                transaction.buyStock,
                                transaction.buyQuantity,
                                transaction.buyTotal,
                                transaction.sellStock,
                                transaction.sellQuantity,
                                transaction.sellTotal,
                                transaction.tradeDate,
                                transaction.closingPrice,
                                transaction.netProfit,
                                transaction.purchaseFee,
                                transaction.sellingFee,
                                transaction.purchaseTax,
                                transaction.sellingTax,
                                transaction.purchaseTotal,
                                transaction.sellingTotal,
                                transaction.standardFee,
                                transaction.baseTax))
                .from(transaction)
                .fetch();
    }


    @Override
    public Long getTransactionsById() {
        return jpaQueryFactory
                .select(transaction.id)
                .from(transaction)
                .orderBy(transaction.id.desc())
                .fetchFirst();
    }



    @Override
    public List<String> getTransactionsByUsername() {
        return jpaQueryFactory
                .select(transaction.username)
                .from(transaction)
                .orderBy(transaction.username.desc())
                .fetch();
    }

    @Override
    public Map<String, Double> getNetProfitByDate() {
        // netProfit을 Double로 변환
        NumberExpression<Double> netProfitAsDouble = Expressions.numberTemplate(Double.class, "CAST({0} AS DOUBLE)", transaction.netProfit);

        return jpaQueryFactory
                .select(transaction.tradeDate, netProfitAsDouble.sum())
                .from(transaction)
                .groupBy(transaction.tradeDate)
                .fetch()
                .stream()
                .collect(Collectors.toMap(
                        tuple -> tuple.get(transaction.tradeDate),
                        tuple -> tuple.get(netProfitAsDouble.sum()),
                        (existing, replacement) -> existing + replacement // 중복 키가 발생했을 때 합계 처리
                ));
    }


    @Override
    public List<TransactionDto> getTransactionsByNetProfit() {
        return List.of();
    }

}
