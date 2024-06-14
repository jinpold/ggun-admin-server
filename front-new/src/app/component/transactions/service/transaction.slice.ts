import { createSlice } from "@reduxjs/toolkit"
import {findAllTransactions, findCount, findNetProfitByDate, findQuantityDate, findTotalByDate } from "./transaction.service"
import { ITransaction } from "../model/transaction.model"

const adminThunks = [findAllTransactions]

const status = {
    pending: 'pending',
    fulfilled: 'fulfilled',
    rejected: 'rejected'
}

interface IAuth{
    status? : number,
    message? : string,
    Token? : string
}

interface TransactionState {
    json? : ITransaction,
    array? : Array<ITransaction>,
    auth? : IAuth
    count? : Number
}

export const initialState:TransactionState = {
    json : {} as ITransaction,
    array : [],
    auth : {} as IAuth,
    count: 0
}



export const transactionSlice = createSlice({
    name: "transactions",
    initialState,
    reducers: {},
    extraReducers: builder => {
        const { pending, rejected } = status;
        builder
            .addCase(findAllTransactions.fulfilled, (state: any, { payload }: any) => { state.array = payload })
            // .addCase(findAllTransactionById.fulfilled, (state: any, { payload }: any) => { state.json = payload })
            .addCase(findCount.fulfilled, (state: any, { payload }: any) => { state.count = payload })
            .addCase(findNetProfitByDate.fulfilled, (state: any, { payload }: any) => { state.json = payload })
            .addCase(findTotalByDate.fulfilled, (state: any, { payload }: any) => { state.json = payload })
            .addCase(findQuantityDate.fulfilled, (state: any, { payload }: any) => { state.json = payload })
    }
})

export const getAllTransactions = (state: any) => state.transaction.array;
export const getSingleTransaction = (state: any) => state.transaction.json;
export const getCountTransaction = (state: any) => state.transaction.count;
export const getMsgTransaction = (state: any) => state.transaction.text;
export const getAuth = (state: any) => state.transaction.auth;
export const getflag = (state: any) => state.transaction.text;
export const getCount = (state: any) => (state.transaction.count)
export const getNetProfit = (state: any) => state.transaction.json;
export const getTotalDate = (state: any) => state.transaction.json;
export const getQuantityDate = (state: any) => state.transaction.json;

export const { } = transactionSlice.actions

export default transactionSlice.reducer;
