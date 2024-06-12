'use client';

import Link from "next/link";
import { useEffect, useState } from "react";
import { useRouter } from "next/navigation";
import { useDispatch } from "react-redux";
import { useSelector } from "react-redux";
import { PG } from "@/app/component/common/enums/PG";
import { Card } from "@mui/material";
import { IAdmin } from "@/app/component/admins/model/admin.model";
import { joinAdmin } from "@/app/component/admins/service/admin.service";
import { getSingleAdmin } from "@/app/component/admins/service/admin.slice";

export default function Join() {

  const router = useRouter();

  const dispatch = useDispatch();
  const join = useSelector(getSingleAdmin);
  const [admin, setAdmin] = useState({} as IAdmin)


  const handleUsername = (e: any) => {
    const {
      target: { value, name }
    } = e;
    setAdmin(dto => ({ ...dto, [name]: value }));
  }

  const handleSubmit = () => {
    console.log(admin)
    dispatch(joinAdmin(admin))
    router.push(`${PG.ADMIN}/login`)
  }


    return (
      <Card sx={{ padding: '1rem', maxWidth: '600px', margin: 'auto', marginTop: '1rem', height:'700px', borderRadius: '12px', border: '2px solid #003366' }}>
        <div className="min-h-[750px] flex justify-center px-3 lg:px-0 py-5">
          <div className="max-w-screen-xl bg-white border h-full shadow sm:rounded-lg flex justify-center flex-1">
            <div className="w-1/3 bg-indigo-950 text-center hidden md:flex">
              <div
                className="m-8 xl:m-12 w-full bg-contain bg-center bg-no-repeat"
                style={{
                }}
              ></div>
            </div>
            <div className="w-2/3 p-4 sm:p-8">
              <div className="flex flex-col items-center">
                <div className="text-center">
                  <h1 className="text-xl xl:text-2xl font-extrabold text-indigo-950">
                    임직원 계정 신규 생성
                  </h1>
                  <p className="text-[10px] text-gray-500">
                    Hey enter your details to create your account
                  </p>
                </div>
                <div className="w-full flex-1 mt-4">
                  <div className="mx-auto max-w-sm flex flex-col gap-3">
                    <input
                      className="w-full px-3 py-2 rounded-lg font-medium bg-gray-100 border border-gray-200 placeholder-gray-500 text-xs focus:outline-none focus:border-gray-400 focus:bg-white"
                      type="text"
                      placeholder="ID : 사원번호 " name="username" onChange={handleUsername}
                    />
                    <input
                      className="w-full px-3 py-2 rounded-lg font-medium bg-gray-100 border border-gray-200 placeholder-gray-500 text-xs focus:outline-none focus:border-gray-400 focus:bg-white"
                      type="Password"
                      placeholder="Enter your password" name="password" onChange={handleUsername}
                    />
                    <input
                      className="w-full px-3 py-2 rounded-lg font-medium bg-gray-100 border border-gray-200 placeholder-gray-500 text-xs focus:outline-none focus:border-gray-400 focus:bg-white"
                      type="text"
                      placeholder="Enter your enpName" name="enpName" onChange={handleUsername}
                    />
                    <input
                      className="w-full px-3 py-2 rounded-lg font-medium bg-gray-100 border border-gray-200 placeholder-gray-500 text-xs focus:outline-none focus:border-gray-400 focus:bg-white"
                      type="text"
                      placeholder="Enter your department" name="department" onChange={handleUsername}
                    />
                    <input
                      className="w-full px-3 py-2 rounded-lg font-medium bg-gray-100 border border-gray-200 placeholder-gray-500 text-xs focus:outline-none focus:border-gray-400 focus:bg-white"
                      type="text"
                      placeholder="Enter your position" name="position" onChange={handleUsername}
                    />
                    <input
                      className="w-full px-3 py-2 rounded-lg font-medium bg-gray-100 border border-gray-200 placeholder-gray-500 text-xs focus:outline-none focus:border-gray-400 focus:bg-white"
                      type="text"
                      placeholder="Enter your job" name="job" onChange={handleUsername}
                    />
                    <input
                      className="w-full px-3 py-2 rounded-lg font-medium bg-gray-100 border border-gray-200 placeholder-gray-500 text-xs focus:outline-none focus:border-gray-400 focus:bg-white"
                      type="tel"
                      placeholder="Enter your email" name="enpEmail" onChange={handleUsername}
                    />
                    <select
                     className="w-full px-3 py-2 rounded-lg font-medium bg-gray-100 border border-gray-200 text-gray-500 text-xs focus:outline-none focus:border-gray-400 focus:bg-white"
                     name="mbti" onChange={handleUsername}>
                     <option value="">Select your role</option>
                     <option value="Super_Admin">G1</option>
                     <option value="hr_Admin">G2</option>
                     <option value="Exec_Admin">G3</option>
                     <option value="Staff_Admin">G4</option>
                     <option value="User">G5</option>
                    </select>
                    <button className="mt-4 tracking-wide font-semibold bg-indigo-950 text-gray-100 w-full py-3 rounded-lg hover:bg-pink-700 transition-all duration-300 ease-in-out flex items-center justify-center focus:shadow-outline focus:outline-none"
                    onClick={handleSubmit}>
                      <span className="ml-3">Sign Up</span>
                    </button>
                    <p className="mt-4 text-xs text-gray-600 text-center">
                      Already have an account?{" "}
                      <Link href={`/`}>
                        <span className="text-blue-900 font-semibold">Sign in</span>
                      </Link>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </Card>
    )
}