import { useEffect, useState } from 'react';
import { Bar } from 'react-chartjs-2';
import {
    Chart as ChartJS,
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    BarElement,
    Title,
    Tooltip,
    Legend,
} from 'chart.js';
import { useDispatch } from 'react-redux';
import { findNetProfitByDate, findTotalByDate } from '../service/transaction.service';

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

interface NetProfitData {
    tradeDate: string;
    netProfit: number;
}

interface TotalDateData {
    tradeDate: string;
    total: number;
}

function Demo2() {
    // const netProfitMap = useSelector(getNetProfit);
    // const totalDateMap = useSelector(getTotalDate);
    // const countTrade = useSelector(getCountTransaction);
    const dispatch = useDispatch();

    const [netProfitData, setNetProfitData] = useState<NetProfitData[]>([]);
    const [totalDateData, setTotalDateData] = useState<TotalDateData[]>([]);

    useEffect(() => {
        dispatch(findNetProfitByDate())
            .then((res: any) => {
                const data = Object.entries(res.payload).map(([tradeDate, netProfit]) => ({
                    tradeDate,
                    netProfit: netProfit as number,
                }));
                data.sort((a, b) => new Date(a.tradeDate).getTime() - new Date(b.tradeDate).getTime());
                setNetProfitData(data);
            });

        dispatch(findTotalByDate())
            .then((res: any) => {
                const data = Object.entries(res.payload).map(([tradeDate, total]) => ({
                    tradeDate,
                    total: total as number,
                }));
                data.sort((a, b) => new Date(a.tradeDate).getTime() - new Date(b.tradeDate).getTime());
                setTotalDateData(data);
            });
        
    }, [dispatch]);

    const data: any = {
        labels: netProfitData.map((i) => i.tradeDate),
        datasets: [
            {
                label: '일별 순이익',
                type: 'bar',
                data: netProfitData.map((i) => i.netProfit),
                backgroundColor: 'rgba(54, 162, 235, 1)',  
            },
            {
                label: '일별 거래 금액',
                type: 'bar',
                data: totalDateData.map((i) => i.total),
                backgroundColor: 'rgba(54, 162, 235, 0.5)',  
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
        <>
         <Bar data={data} options={options} />
        </>
    );
}

export default Demo2;
