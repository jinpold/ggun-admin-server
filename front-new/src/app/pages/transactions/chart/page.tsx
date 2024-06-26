'use client'
import { useEffect } from "react";
import Chart2 from "@/app/component/transactions/modul/transaction";
import { Chart } from "react-chartjs-2";
import { useDispatch, useSelector } from "react-redux";
import { get } from "http";
import { getCount } from "@/app/component/transactions/service/transaction.slice";
import { findCount } from "@/app/component/transactions/service/transaction.service";


export default function NewsPage() {

    const dispatch = useDispatch()
    const countTransactions = useSelector(getCount)

    useEffect(() => {
        dispatch(findCount())
    }, [dispatch])


    return (
        <div>
            <h2> 거래건수 :{countTransactions} </h2>
            <div className='flex justify-center w-screen h-screen'>
                {/* <Mychart nps={allNps} /> */}

                <Chart2/>
            </div>

            {/* <div className='flex justify-center w-screen h-screen'>
                <button onClick={()=>paramsData(allNps)}>zmffjrdmt </button>
            </div> */}

            {/* <div>
                <ul>
                    {allNps.map((i: any) => (
                        <li key={i.id}>솔라{i.stock}</li>
                    ))}
                </ul>
            </div> */}
        </div>
    )
}