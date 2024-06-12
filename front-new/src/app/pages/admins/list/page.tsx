'use client'
import { NextPage } from "next"
import { useEffect, useState } from "react"
import { useSelector, useDispatch } from "react-redux"
import { Typography } from "@mui/material"
import { DataGrid } from "@mui/x-data-grid"
import { get } from "http"
import { getAllAdmins, getCountAdmin } from "@/app/component/admins/service/admin.slice"
import { findAllAdmins, findCount } from "@/app/component/admins/service/admin.service"
import adminColumns from "@/app/component/admins/modul/admin-columns"
import { PG } from "@/app/component/common/enums/PG"
import MoveButton from "@/app/atoms/button/MoveButton"
import { jwtDecode } from "jwt-decode"
import { parseCookies } from "nookies"

const AdimnsPage: NextPage = () => {
    const [pageSize, setPageSize] = useState(5); 

    const dispatch = useDispatch()
    const allAdmins = useSelector(getAllAdmins)
    const countUsers = useSelector(getCountAdmin)

    useEffect(() => {
        dispatch(findAllAdmins(1))
        dispatch(findCount())
    }, [dispatch])

    return (
        <>
            <h2> 임직원 수 :{countUsers} </h2>

            <div style={{ height: "100%", width: "100%" }}>
                {allAdmins && <DataGrid 
                    rows={allAdmins}
                    columns={adminColumns()}
                    pageSizeOptions={[5, 10, 20]} 
                    checkboxSelection
                />}

             <td>
            <MoveButton text={"계정 생성"} path={`${PG.ADMIN}/join`}/>
             </td>
            </div>
        </>
    )
}
// path={`${PG.ADMIN}/detail/${jwtDecode<any>(parseCookies().accessToken).adminId}`}
export default AdimnsPage