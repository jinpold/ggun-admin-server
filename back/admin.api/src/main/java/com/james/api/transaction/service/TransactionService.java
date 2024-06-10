package com.james.api.transaction.service;
import com.james.api.common.service.CommandService;
import com.james.api.common.service.QueryService;
import com.james.api.transaction.model.Transaction;
import com.james.api.transaction.model.TransactionDto;


public interface TransactionService extends CommandService<TransactionDto>, QueryService<TransactionDto> {

    default Transaction dtoToEntity(TransactionDto dto){
        return Transaction.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .buyStock(dto.getBuyStock())
                .buyQuantity(dto.getBuyQuantity())
                .buyTotal(dto.getBuyTotal())
                .sellStock(dto.getSellStock())
                .sellQuantity(dto.getSellQuantity())
                .sellTotal(dto.getSellTotal())
                .tradeDate(dto.getTradeDate())
                .closingPrice(dto.getClosingPrice())
                .netProfit(dto.getNetProfit())
                .purchaseFee(dto.getPurchaseFee())
                .sellingFee(dto.getSellingFee())
                .purchaseTax(dto.getPurchaseTax())
                .sellingTax(dto.getSellingTax())
                .purchaseTotal(dto.getPurchaseTotal())
                .sellingTotal(dto.getSellingTotal())
                .standardFee(dto.getStandardFee())
                .baseTax(dto.getBaseTax())
                .build();
    }

    default TransactionDto entityToDto(Transaction ent) {
        return TransactionDto.builder()
                .id(ent.getId())
                .username(ent.getUsername())
                .buyStock(ent.getBuyStock())
                .buyQuantity(ent.getBuyQuantity())
                .buyTotal(ent.getBuyTotal())
                .sellStock(ent.getSellStock())
                .sellQuantity(ent.getSellQuantity())
                .sellTotal(ent.getSellTotal())
                .tradeDate(ent.getTradeDate())
                .closingPrice(ent.getClosingPrice())
                .netProfit(ent.getNetProfit())
                .purchaseFee(ent.getPurchaseFee())
                .sellingFee(ent.getSellingFee())
                .purchaseTax(ent.getPurchaseTax())
                .sellingTax(ent.getSellingTax())
                .purchaseTotal(ent.getPurchaseTotal())
                .sellingTotal(ent.getSellingTotal())
                .standardFee(ent.getStandardFee())
                .baseTax(ent.getBaseTax())
                .build();
    }
}
