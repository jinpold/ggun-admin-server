import { Link } from '@mui/material'
import { GridColDef } from '@mui/x-data-grid'
import { PG } from '@/app/component/common/enums/PG';
import { MyTypography } from '../../common/style/cell';
import { ITransaction } from '../model/transaction.model';


export default function transactionColumns(): GridColDef[] {

    interface CellType {
        row: ITransaction;
    }
    return [
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'id',
            headerName: 'No.',
            renderCell: ({ row }: CellType) => MyTypography(row.id, "1.5rem")
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'username',
            headerName: '성명',
            renderCell: ({ row }: CellType) =>
                MyTypography(
                    // <Link href={`${PG.ADMIN}/detail/${row.id}`}> {row.username} </Link>
                    row.username,"1.5rem")
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'buyStock',
            headerName: '매수 주식',
            renderCell: ({ row }: CellType) => MyTypography(row.buyStock, "1.5rem")
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'buyQuantity',
            headerName: '매수 수량  ',
            renderCell: ({ row }: CellType) => MyTypography(row.buyQuantity, "1.5rem")
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'buyTotal',
            headerName: '매수 총액',
            renderCell: ({ row }: CellType) => MyTypography(row.buyTotal, "1.5rem")
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'sellStock',
            headerName: '매도 주식',
            renderCell: ({ row }: CellType) => MyTypography(row.sellStock, "1.5rem")
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'sellQuantity',
            headerName: '매도 수량  ',
            renderCell: ({ row }: CellType) => MyTypography(row.sellQuantity, "1.5rem")
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'sellTotal',
            headerName: '매도 총액',
            renderCell: ({ row }: CellType) => MyTypography(row.sellTotal, "1.5rem")
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'tradeDate',
            headerName: '거래일자',
            renderCell: ({ row }: CellType) => MyTypography(row.tradeDate, "1.5rem")
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'closingPrice',
            headerName: '거래 가격',
            renderCell: ({ row }: CellType) => MyTypography(row.closingPrice, "1.5rem")
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'netProfit',
            headerName: '순이익',
            renderCell: ({ row }: CellType) => MyTypography(row.netProfit, "1.5rem")
        }
    ]
}