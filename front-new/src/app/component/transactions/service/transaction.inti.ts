import { ITransaction } from "../model/transaction.model";


export const initialState: ITransaction = {
    id :0,
    username: "",
    buyStock: "",
    buyQuantity: "",
    buyTotal: "",
    sellStock: "",
    sellQuantity: "",
    sellTotal: "",
    tradeDate: "",
    closingPrice: "",
    netProfit: "",
    purchaseFee: "",
    sellingFee: "",
    purchaseTax: "",
    sellingTotal: "",
    standardFee: "",
    baseTax: ""
}