import { createSlice } from "@reduxjs/toolkit"
import { IChat } from "../model/chat.model"
import { findChat } from "./chat.service"


const adminThunks = [findChat]

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

interface ChatState {
    json? : IChat,
    array? : Array<IChat>,
    auth? : IAuth
    count? : Number
}

export const initialState:ChatState = {
    json : {} as IChat,
    array : [],
    auth : {} as IAuth,
    count: 0
}



export const transactionSlice = createSlice({
    name: "chats",
    initialState,
    reducers: {},
    extraReducers: builder => {
        const { pending, rejected } = status;
        builder
            .addCase(findChat.fulfilled, (state: any, { payload }: any) => { state.array = payload })
            
    }
})

export const getChat = (state: any) => state.transaction.array;


export const { } = transactionSlice.actions

export default transactionSlice.reducer;
