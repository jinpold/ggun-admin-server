package com.james.api.transaction.service;

import com.james.api.common.component.Messenger;
import com.james.api.transaction.model.TransactionDto;
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

    @Override
    public Messenger save(TransactionDto transactionDto) {
        return null;
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
        return List.of();
    }

    @Override
    public Optional<TransactionDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Long count() {
        return 0L;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
