import { createAsyncThunk } from "@reduxjs/toolkit";
import { IAdmin } from "../model/admin.model";
import { countAdminsAPI, deleteAdminByIdAPI, existsByUsernameAPI, findAdminByIdAPI, findAllAdminsAPI, findCountAPI, joinAdminAPI, loginAdminAPI, logoutAPI, modifyAdminByIdAPI } from "./admin.api";

export const findAllAdmins: any = createAsyncThunk(
    'admins/findAllAdmins',
    async (page: number) => await findAllAdminsAPI(1)
)

export const findAdminById: any = createAsyncThunk(
    'admins/findAdminById',
    async (id: number) => await findAdminByIdAPI(id)
)

export const findCountAdmins: any = createAsyncThunk(
    'admins/findCountAdmins',
    async () => await countAdminsAPI()
)

export const modifyAdminById: any = createAsyncThunk(
    'admins/modifyAdminById',
    async (admin: IAdmin) => await modifyAdminByIdAPI(admin)
)

export const deleteAdminById: any = createAsyncThunk(
    'admins/deleteAdminById',
    async (id: number) => await deleteAdminByIdAPI(id)
)

export const loginAdmin: any = createAsyncThunk(
    'admins/loginAdmin',
    async (props: IAdmin) => await loginAdminAPI(props)
)

export const joinAdmin: any = createAsyncThunk(
    'admins/joinAdmin',
    async (props: IAdmin) => await joinAdminAPI(props)
)

export const existsByUsername:any = createAsyncThunk(
    'admins/existsByUsername',
    async (username: string) => await existsByUsernameAPI(username)
)

export const logout:any = createAsyncThunk(
    'admins/logout',
    async () => await logoutAPI()
)

export const findCount: any = createAsyncThunk( 
    'admins/findCount',                      
    async () => {
        console.log('findCount : ')
        const data: any = await findCountAPI(); 

        return data
    }
)