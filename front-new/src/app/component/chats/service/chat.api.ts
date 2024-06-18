import  instance  from "@/app/component/common/configs/axios-config"


export const findChatAPI = async () =>{    
    try{                                                        
        const response = await instance().get('/api/chat',{
            params: {}
        })
        return response.data
    }catch(error){
        console.log(error)
        return error
    }

}
