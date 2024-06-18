import { createAsyncThunk } from "@reduxjs/toolkit";


export const findChat: any = createAsyncThunk( 
    'Chats/findChat',                      
    async () => (await findChat())
)