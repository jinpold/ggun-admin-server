import  instance  from "@/app/component/common/configs/axios-config"
import { IAdmin } from "../model/admin.model"

export const findAllAdminsAPI = async (page: number) => {
    try {
        const response = await instance().get('/admins/list', {
            params: { page, limit: 10 } 
        })
        return response.data
    } catch (error) {
        console.log(error, " findAllAdminsAPI EERR!!!")
        return error
    }
}

export const findAdminByIdAPI = async (id: number) => {
    try {
        const response = await instance().get('/admins/detail', {
            params: { id }
        })
        return response.data
    } catch (error) {
        console.log(error, " findAdminByIdAPI EERR!!!")
        return error
    }
}

export const countAdminsAPI = async () => {
    try {
        const response = await instance().get('/admins/count')

        return response.data
    } catch (error) {
        console.log(error, " countAdminsAPI EERR!!!")
        return error
    }
}

export const modifyAdminByIdAPI = async (props: any) => {
    try {
        const response = await instance().put('/admins/modify', props)
        console.log("response ", JSON.stringify(response.data))
        return response.data
    } catch (error) {
        console.log(error, " modifyAdminByIdAPI EERR!!!")
        return error
    }
}

export const deleteAdminByIdAPI = async (id: number) => {
    try {
        const response = await instance().delete('/admins/delete', {
            params: { id }
        })
        console.log("response ", response)
        return response.data
    } catch (error) {
        console.log(error, " deleteAdminByIdAPI EERR!!!")
        return error
    }
}

export const loginAdminAPI = async (props: any) => {
    try {
        const response = await instance().post('/auth/login', props)
        return response.data
    } catch (error) {
        console.log(error, "loginAdminAPI EERR!!!")
        return error
    }
}

export const joinAdminAPI = async (props: any) => {
    try {
        const response = await instance().post('/admins/save', props)
        console.log("response ", JSON.stringify(response.data))
        return response.data
    } catch (error) {
        console.log(error, " joinAdminAPI EERR!!!")
        return error
    }
}

export const existsByUsernameAPI = async (username: string) => {
    try {
        const response = await instance().get('/auth/exists-username', {
            params: {username} 
        })
        console.log("exist username response "+ response.data)
        return response.data
    } catch (error) {
        console.log(error, " AdminExistsByUsernameAPI EERR!!!")
        return error
    }
}

export const logoutAPI = async () =>{
    try{
        const response = await instance().get('/admins/logout',)
        console.log('logout response', JSON.stringify(response.data))
        return response.data
    }catch(error){
        console.log(error, " AdminlogoutAPI EERR!!!")
        return error
    }
}

export const findCountAPI = async () => {
    try{
        const response = await instance().get('/admins/count',{
            params: {}
        })
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
}