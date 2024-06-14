import  instance  from "@/app/component/common/configs/axios-config"
import { ITransaction } from "../model/transaction.model"



export const findAlltransactionsAPI = async (page: number) =>{   
    try{                                                       
        const response = await instance().get('/transactions/list',{
            params: {page, size:20, limit: 20}
        })
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
    
}

// export const findTransactionsByIdAPI = async (id: number) =>{      
//     try{                                                      
//         const response = await instance().get('/boards/detail',{params: {id}})
//         return response.data
//     }catch(error){
//         console.log(error)
//         return error
//     }
// }



export const findNetProfitByDateAPI = async () =>{ 
    try{                                                       
        const response = await instance().get('/transactions/netProfitByDate',{
            params: {}
        })
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
}

export const findTotalByDateAPI = async () =>{ 
    try{                                                       
        const response = await instance().get('/transactions/TotalByDate',{
            params: {}
        })
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
}

export const findQuantityDate = async () =>{ 
    try{                                                       
        const response = await instance().get('/transactions/QuantityByDate',{
            params: {}
        })
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
}

export const findCountAPI = async () =>{    
    try{                                                        
        const response = await instance().get('/transactions/count',{
            params: {}
        })
        return response.data
    }catch(error){
        console.log(error)
        return error
    }

}
