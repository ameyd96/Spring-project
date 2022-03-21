import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import EmployeeService from "../services/EmployeeService";

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
              <tr key={emp.id}>
                <td className="text-left px-6 py-4 whitespace-nowrap">
                  <div className="text-sm text-gray-500">{emp.firstName}</div>
                </td>
                <td className="text-left px-6 py-4 whitespace-nowrap">
                  <div className="text-sm text-gray-500">{emp.lastName}</div>
                </td>
                <td className="text-left px-6 py-4 whitespace-nowrap">
                  <div className="text-sm text-gray-500">{emp.email}</div>
                </td>
                <td className="text-right px-6 py-4 whitespace-nowrap font-medium text-sm">
                  <a
                    href="#"
                    className="text-indigo-500 hover:text-indigo-800 px-4"
                  >
                    Edit
                  </a>
                  <a
                    href="#"
                    className="text-indigo-500 hover:text-indigo-800 "
                  >
                    Delete
                  </a>
                </td>
              </tr>
              ))}
            </tbody>
          )}
        </table>
      </div>
    </div>
  );
};

export default EmployeeList;
