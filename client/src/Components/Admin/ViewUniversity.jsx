import React, { useEffect } from "react";
import { useState } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";
import AdminNav from "./AdminNav";

const ViewUniversity = () => {
  const navigate = useNavigate();
  const [data, setData] = useState([]);
  const getStudents = async () => {
    const res = await axios.get(`http://localhost:8080/api/v1/university`);
    console.log(res.data, "university");
    setData(res.data);
  };
  useEffect(() => {
    getStudents();
  }, []);
  return (
    <div>
      <AdminNav />
      <div className="flex justify-center mt-3 bg-clip-padding ">
        <h2 className="text-4xl text-black font-bold p-3 border-4 rounded-lg">
          Univeristy List
        </h2>
      </div>
      <div className="flex justify-end mt-3 bg-clip-padding  ">
        <h2 className="text-xl bg-neutral-300 text-black font-bold p-1 mr-20 border-4 rounded-lg">
          <Link to={"/addUniversity"}>AddUniversity</Link>
        </h2>
      </div>
      <div class="flex justify-center mt-5">

        <table class=" text-center text-sm  bg-white w-8/12 border-8  border-blue-200 ">
          <thead class="border-b font-medium border-4  border-pink-500  ">
            <tr>
              <th scope="col" class="px-6 py-2 text-lg">
                Email
              </th>
              <th scope="col" class="px-6 py-2 text-lg">
                Location
              </th>
              <th scope="col" class="px-6 py-2 text-lg">
                Action
              </th>
              
            </tr>
          </thead>
          <tbody>
            {data.map((item) => {
              return (
                <tr class="border-b dark:border-neutral-500">
                  <td class="whitespace-nowrap px-6 py-2">{item.name}</td>
                  <td class="whitespace-nowrap px-6 py-2">{item.location}</td>
                  <td class="whitespace-nowrap px-6 py-2">
                  <button
                    className="mt-10 block w-full select-none rounded-lg bg-violet-400 py-3 px-6  align-middle font-sans text-xs font-bold uppercase text-white shadow-md shadow-pink-500/20 transition-all hover:shadow-lg hover:shadow-pink-500/40 focus:opacity-[0.85] focus:shadow-none active:opacity-[0.85] active:shadow-none disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
                    type="submit" onClick={()=>navigate(`/addscholarship/${item.id}`)}
                    data-ripple-light="true"
                  >
                    AddScholarship
                  </button>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ViewUniversity;
