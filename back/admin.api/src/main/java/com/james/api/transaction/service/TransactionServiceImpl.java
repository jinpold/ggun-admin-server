package com.james.api.transaction.service;

import com.james.api.admin.model.Admin;
import com.james.api.common.component.Messenger;
import com.james.api.transaction.model.Transaction;
import com.james.api.transaction.model.TransactionDto;
import com.james.api.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public Messenger save(TransactionDto transactionDto) {
        Transaction transaction = transactionRepository.save(dtoToEntity(transactionDto));
        System.out.println((transaction instanceof Transaction) ? "SUCCESS" : "FAILURE");
        return Messenger.builder()
                .message((transaction instanceof Transaction) ? "SUCCESS" : "FAILURE")
                .build();
    }

    @Override
    public Messenger deleteById(Long id) {
        return null;
    }

    @Override
    public Messenger modify(TransactionDto transactionDto) {
        return null;
    }

    @Override
    public List<TransactionDto> findAll() throws SQLException {
        return transactionRepository.findAll().stream().map(i->entityToDto(i)).toList();
    }

    @Override
    public Optional<TransactionDto> findById(Long id) {
        return transactionRepository.findById(id).stream().map(i -> entityToDto(i)).findAny();
    }

    @Override
    public Long count() {
        return transactionRepository.count();
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
