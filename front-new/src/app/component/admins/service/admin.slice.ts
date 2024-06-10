import { createSlice } from "@reduxjs/toolkit"
import { IAdmin } from "../model/admin.model"
import { deleteAdminById, existsByUsername, findAdminById, findAllAdmins, findCount, findCountAdmins, joinAdmin, loginAdmin, modifyAdminById } from "./admin.service"

const adminThunks = [findAllAdmins]

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

interface AdminState {
    json? : IAdmin,
    array? : Array<IAdmin>,
    auth? : IAuth
}

export const initialState:AdminState = {
    json : {} as IAdmin,
    array : [],
    auth : {} as IAuth
}



export const adminSlice = createSlice({
    name: "admins",
    initialState,
    reducers: {},
    extraReducers: builder => {
        const { pending, rejected } = status;
        builder
            .addCase(findAllAdmins.fulfilled, (state: any, { payload }: any) => { state.array = payload })
            .addCase(findAdminById.fulfilled, (state: any, { payload }: any) => { state.json = payload })
            .addCase(findCountAdmins.fulfilled, (state: any, { payload }: any) => { state.count = payload })
            .addCase(modifyAdminById.fulfilled, (state: any, { payload }: any) => { state.json  = payload })
            .addCase(deleteAdminById.fulfilled, (state: any, { payload }: any) => { state.json = payload })
            .addCase(loginAdmin.fulfilled, (state: any, { payload }: any) => { state.auth = payload })
            .addCase(joinAdmin.fulfilled, (state: any, { payload }: any) => { state.json = payload })
            .addCase(existsByUsername.fulfilled, (state: any, { payload }: any) => { state.text = payload })
            .addCase(findCount.fulfilled, (state:any, {payload}:any) => {state.count = payload})
    }
})

export const getAllAdmins = (state: any) => state.admin.array;
export const getSingleAdmin = (state: any) => state.admin.json;
export const getCountAdmin = (state: any) => state.admin.count;
export const getAuth = (state: any) => state.admin.auth;
export const getflag = (state: any) => state.admin.text;
export const getCount = (state: any) => (state.admin.count)

export const { } = adminSlice.actions

export default adminSlice.reducer;
