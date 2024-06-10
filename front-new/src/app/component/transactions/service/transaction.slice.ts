import { createSlice } from "@reduxjs/toolkit"
import {findAllTransactions, findCount } from "./transaction.service"
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
}

export const initialState:TransactionState = {
    json : {} as ITransaction,
    array : [],
    auth : {} as IAuth
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
    }
})

export const getAllTransactions = (state: any) => state.transaction.array;
export const getSingleTransaction = (state: any) => state.transaction.json;
export const getCountTransaction = (state: any) => state.transaction.count;
export const getAuth = (state: any) => state.transaction.auth;
export const getflag = (state: any) => state.transaction.text;
export const getCount = (state: any) => (state.transaction.count)

export const { } = transactionSlice.actions

export default transactionSlice.reducer;
