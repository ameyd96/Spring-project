import React from 'react'

const Employee = ({emp}) => {
  return (
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
  )
}

export default Employee