import { createAsyncThunk } from "@reduxjs/toolkit";
import { ITransaction } from "../model/transaction.model";
import { findAlltransactionsAPI, findCountAPI, findNetProfitByDateAPI, findTotalByDateAPI } from "./transaction.api";


export const findAllTransactions: any = createAsyncThunk( 
    'Transactions/findAllTransactions',                        
    async (page: number) => {
        console.log('findAllTransactions page : ' + page)
        const data: any = await findAlltransactionsAPI(page); 

        const { message, result }: any = data;

        return data
    }
)
export const findNetProfitByDate: any = createAsyncThunk( 
    'Transactions/findNetProfitByDate',                      
    async () => (await findNetProfitByDateAPI())
   
)

export const findTotalByDate: any = createAsyncThunk( 
    'Transactions/findTotalByDate',                      
    async () => (await findTotalByDateAPI())
   
)

export const findCount: any = createAsyncThunk( 
    'Transactions/findCount',                      
    async () => (await findCountAPI())
)

export const findQuantityDate: any = createAsyncThunk( 
    'Transactions/findQuantityDate',                      
    async () => (await findCountAPI())
)