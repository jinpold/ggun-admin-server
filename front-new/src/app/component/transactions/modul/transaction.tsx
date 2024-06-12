import { useRef, useEffect, MutableRefObject } from 'react';
import { Bar, Doughnut, Line } from 'react-chartjs-2';
import {
    Chart as ChartJS,
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    BarElement, // 추가된 부분
    Title,
    Tooltip,
    Legend,
} from 'chart.js';
import { NextPage } from 'next';
import { useSelector, useDispatch } from 'react-redux';
import { ITransaction } from '../model/transaction.model';
import { getAllTransactions, getNetProfit } from '../service/transaction.slice';
import { findAllTransactions, findCount, findNetProfitByDate } from '../service/transaction.service';

ChartJS.register(
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    BarElement, 
    Title,
    Tooltip,
    Legend
);

function Demo2() {
    const netProfitMap = useSelector(getNetProfit);
    const dispatch = useDispatch();

    useEffect(() => {
        dispatch(findCount())
        dispatch(findNetProfitByDate())
            .then((res: any) => {
                console.log("res : " + JSON.stringify(res));
            });
    }, [dispatch]);

    // Map을 배열로 변환
    const allTransactions = Object.entries(netProfitMap).map(([tradeDate, netProfit]) => ({
        tradeDate,
        netProfit,
    }));

    const data: any = {
        labels: allTransactions.map((i) => i.tradeDate),
        datasets: [
            {
                label: '일별 순이익',
                type: 'bar', 
                data: allTransactions.map((i) => i.netProfit),
                backgroundColor: 'rgb(54, 162, 235)',
            },
            {
                label: 'tax',
                type: 'bar', 
                data: allTransactions.map((i) => i.netProfit),
                backgroundColor: 'blue',
            },
        ],
    };

    const options: any = { 
        scales: {
            x: {
                stacked: true,
            },
            y: {
                stacked: true,
            }
        }
    };

    return (
        <Bar data={data} options={options}></Bar>
    );
}

export default Demo2;