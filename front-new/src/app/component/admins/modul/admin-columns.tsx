import { Link } from '@mui/material'
import { GridColDef } from '@mui/x-data-grid'
import { PG } from '@/app/component/common/enums/PG';
import { IAdmin } from '../model/admin.model';
import { MyTypography } from '../../common/style/cell';


export default function adminColumns(): GridColDef[] {

    interface CellType {
        row: IAdmin;
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
            headerName: '계정',
            renderCell: ({ row }: CellType) =>
                MyTypography(
                    <Link href={`${PG.ADMIN}/detail/${row.id}`}> {row.username} </Link>
                    , "1.5rem")
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'password',
            headerName: '비밀번호',
            renderCell: ({ row }: CellType) => {
                MyTypography(row.password, "1.5rem")
                return MyTypography('********', "1.5rem")
            }
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'enpName',
            headerName: '성명',
            renderCell: ({ row }: CellType) => MyTypography(row.enpName, "1.5rem")
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'enpNum',
            headerName: '사번',
            renderCell: ({ row }: CellType) => MyTypography(row.enpNum, "1.5rem")
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'department',
            headerName: '부서',
            renderCell: ({ row }: CellType) => MyTypography(row.department, "1.5rem")
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'position',
            headerName: '직책',
            renderCell: ({ row }: CellType) => MyTypography(row.position, "1.5rem")
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'job',
            headerName: '직무',
            renderCell: ({ row }: CellType) => MyTypography(row.job, "1.5rem")
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'enpEmail',
            headerName: 'Email',
            renderCell: ({ row }: CellType) => MyTypography(row.enpEmail, "1.5rem")
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'phone',
            headerName: '전화번호',
            renderCell: ({ row }: CellType) => MyTypography(row.phone, "1.5rem")
        },
        {
            flex: 0.04,
            minWidth: 30,
            sortable: false,
            field: 'role',
            headerName: '권한',
            renderCell: ({ row }: CellType) => MyTypography(row.role, "1.5rem")
        }
    ]
}