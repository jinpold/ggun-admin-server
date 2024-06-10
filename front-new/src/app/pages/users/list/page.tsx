'use client'
import { NextPage } from "next"
import { useEffect, useState } from "react"
import { useSelector, useDispatch } from "react-redux"
import { Typography } from "@mui/material"
import { getAllUsers, getCount } from "@/app/component/users/service/user.slice"
import userColumns from "@/app/component/users/modul/user-columns"
import { DataGrid } from "@mui/x-data-grid"
import { fetchAllUsers, findCount } from "@/app/component/users/service/user.service"

const UsersPage: NextPage = () => {
    const [pageSize, setPageSize] = useState(5); 

    const dispatch = useDispatch()
    const allUsers = useSelector(getAllUsers)
    const countUsers = useSelector(getCount)

    useEffect(() => {
        dispatch(fetchAllUsers(1))
        dispatch(findCount())
    }, [dispatch])

    return (
        <>
            <h2> 사용자 수 :{countUsers} </h2>

            <div style={{ height: "100%", width: "100%" }}>
                {allUsers && <DataGrid 
                    rows={allUsers}
                    columns={userColumns()}
                    pageSizeOptions={[5, 10, 20]} 
                    checkboxSelection
                />}
            </div>
        </>
    )
}
export default UsersPage