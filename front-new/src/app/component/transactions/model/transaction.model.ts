export interface ITransaction {
    id? :number;
    username: string;
    buyStock: string;
    buyQuantity?: string;
    buyTotal?: string;
    sellStock?: string;
    sellQuantity?: string;
    sellTotal?: string;
    tradeDate?: string;
    closingPrice?: string;
    netProfit?: string;
    purchaseFee?: string;
    sellingFee?: string;
    purchaseTax?: string;
    sellingTotal?: string;
    standardFee?: string;
    baseTax?: string;
}