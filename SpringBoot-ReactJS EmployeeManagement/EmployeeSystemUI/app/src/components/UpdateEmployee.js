import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import EmployeeService from "../services/EmployeeService";

const UpdateEmployee = () => {
  const navigate = useNavigate();
  const [employee, setEmployee] = useState({
    id: "",
    firstName: "",
    lastName: "",
    email: "",
  });
  const { id } = useParams();
  const handleChange = (e) => {
    const value = e.target.value;
    setEmployee({ ...employee, [e.target.name]: value });
  };

  const updateEmployee = (e) => {
    e.preventDefault();

    EmployeeService.updateEmployee(employee, id)
      .then((response) => {
          navigate("/employeeList");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    const fetchdata = async () => {
      try {
        const response = await EmployeeService.getEmployeeById(id);
        setEmployee(response.data);
      } catch (error) {
        console.log(error);
      }
    };
    fetchdata();
  }, []);

  return (
    <div className="flex max-w-2xl mx-auto shadow border-b">
      <div className="px-8 py-8">
        <div className="font-thin text-2xl tracking-wider">
          <h1>Update Employee</h1>
          <div className="items-center justify-center h-14 w-full my-4">
            <label className="block text-gray-400 text-sm font-normal">
              First Name
            </label>
            <input
              name="firstName"
              value={employee.firstName}
              onChange={(e) => handleChange(e)}
              type="text"
              className="h-10 w-96 border mt-2 px-2 py-2"
            ></input>
          </div>

          <div className="items-center justify-center h-14 w-full my-4">
            <label className="block text-gray-400 text-sm font-normal">
              Last Name
            </label>
            <input
              type="text"
              name="lastName"
              value={employee.lastName}
              onChange={(e) => handleChange(e)}
              className="h-10 w-96 border mt-2 px-2 py-2"
            ></input>
          </div>

          <div className="items-center justify-center h-14 w-full my-4">
            <label className="block text-gray-400 text-sm font-normal">
              Email
            </label>
            <input
              type="email"
              name="email"
              value={employee.email}
              onChange={(e) => handleChange(e)}
              className="h-10 w-96 border mt-2 px-2 py-2"
            ></input>
          </div>

          <div className="items-center justify-center h-14 w-full my-10 space-x-5">
            <button
              onClick={updateEmployee}
              className="rounded text-white font-semibold bg-blue-400 hover:bg-blue-700 px-6 py-2"
            >
              Update
            </button>
            <button
              onClick={() => navigate("/employeeList")}
              className="rounded text-white font-semibold bg-orange-400 hover:bg-orange-700 px-6 py-2"
            >
              Cancel
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default UpdateEmployee;
