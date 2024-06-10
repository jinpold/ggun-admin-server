'use client'
import { NextPage } from "next"
import { useEffect, useState } from "react"
import { useSelector, useDispatch } from "react-redux"
import { Typography } from "@mui/material"
import { DataGrid } from "@mui/x-data-grid"
import { getAllTransactions, getCountTransaction } from "@/app/component/transactions/service/transaction.slice"
import { findAllTransactions, findCount } from "@/app/component/transactions/service/transaction.service"
import transactionColumns from "@/app/component/transactions/modul/transaction-columns"



const TransactionPage: NextPage = () => {
    const [pageSize, setPageSize] = useState(5); 

    const dispatch = useDispatch()
    const allTransactions = useSelector(getAllTransactions)
    const countTransactions = useSelector(getCountTransaction)

    useEffect(() => {
        dispatch(findAllTransactions(1))
        dispatch(findCount())
    }, [dispatch])

    return (
        <>
            <h2> 거래건수 :{countTransactions} </h2>

            <div style={{ height: "100%", width: "100%" }}>
                {allTransactions && <DataGrid 
                    rows={allTransactions}
                    columns={transactionColumns()}
                    pageSizeOptions={[5, 10, 20]} 
                    checkboxSelection
                />}
            </div>
        </>
    )
}
export default TransactionPage