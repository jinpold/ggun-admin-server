import { createAsyncThunk } from "@reduxjs/toolkit";
import { ITransaction } from "../model/transaction.model";
import { findAlltransactionsAPI, findCountAPI, findNetProfitByDateAPI } from "./transaction.api";


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

export const findCount: any = createAsyncThunk( 
    'Transactions/findCount',                      
    async () => (await findCountAPI())
)