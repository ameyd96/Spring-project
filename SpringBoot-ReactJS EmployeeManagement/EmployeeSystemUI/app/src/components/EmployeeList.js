import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import EmployeeService from "../services/EmployeeService";
import Employee from "./Employee";

const EmployeeList = () => {
  const [employee, setEmployee] = useState(null);
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();

  const fetchData = async () => {
    setLoading(true);
    try {
      const response = await EmployeeService.getEmployee();
      setEmployee(response.data);
    } catch (error) {
      console.log(error);
    }
    setLoading(false);
  };

  const deleteEmployee =(e,id) => {
    e.preventDefault();

    EmployeeService.deleteEmployee(id).then((res) =>{
      if(employee){
        setEmployee((prevElement) =>{
          return prevElement.filter((employee) => employee.id !== id);
        })
      }
    })

  }
  useEffect(() => {
    fetchData();
  }, []);

  return (
    <div className="container mx-auto my-8">
      <div className="h-12">
        <button
          className="rounded bg-slate-600 text-white px-6 py-2"
          onClick={() => navigate("/addEmployee")}
        >
          Add Employee
        </button>
      </div>
      <div className="flex shadow border-b">
        <table className="min-w-full">
          <thead className="bg-gray-100">
            <tr>
              <th className="text-left font-medium uppercase tracking-wider px-6 py-3">
                First Name
              </th>
              <th className="text-left font-medium uppercase tracking-wider px-6 py-3">
                Last Name
              </th>
              <th className="text-left font-medium uppercase tracking-wider px-6 py-3">
                Email
              </th>
              <th className="text-right font-medium uppercase tracking-wider px-6 py-3">
                Actions
              </th>
            </tr>
          </thead>
          {!loading && (
            <tbody>
              {employee.map((emp) =>(
              <Employee emp={emp} key={emp.id} deleteEmployee={deleteEmployee}/>
              ))}
            </tbody>
          )}
        </table>
      </div>
    </div>
  );
};

export default EmployeeList;
