export interface IAdmin {
    id? :number;
    username: string;
    password: string;
    enpName?: string;
    enpNum?: string;
    department?: string;
    position?: string;
    job?: string;
    enpEmail?: string;
    phone?: number;
    role?: string;
    regDate?: string;
    modDate?: string;
    count?: number;
}