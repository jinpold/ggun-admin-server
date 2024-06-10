import { createAsyncThunk } from "@reduxjs/toolkit";
import { ITransaction } from "../model/transaction.model";
import { findAlltransactionsAPI, findCountAPI } from "./transaction.api";


export const findAllTransactions: any = createAsyncThunk( 
    'Transactions/findAllTransactions',                        
    async (page: number) => {
        console.log('findAllTransactions page : ' + page)
        const data: any = await findAlltransactionsAPI(page); 

        const { message, result }: any = data;

        return data
    }
)
// export const findAllTransactionById: any = createAsyncThunk( 
//     'Transactions/findAllTransactionById',                      
//     async (id: number) => (await findTransactionByIdAPI(id))
   
// )

export const findCount: any = createAsyncThunk( 
    'Transactions/findCount',                      
    async () => (await findCountAPI())
)