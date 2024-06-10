package com.james.api.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class TransactionDto {

    private Long id;
    private String username;
    private String buyStock;
    private String buyQuantity;
    private String buyTotal;
    private String sellStock;
    private String sellQuantity;
    private String sellTotal;
    private String tradeDate;
    private String closingPrice;
    private String netProfit;
    private String purchaseFee;
    private String sellingFee;
    private String purchaseTax;
    private String sellingTax;
    private String purchaseTotal;
    private String sellingTotal;
    private String standardFee;
    private String baseTax;
}
