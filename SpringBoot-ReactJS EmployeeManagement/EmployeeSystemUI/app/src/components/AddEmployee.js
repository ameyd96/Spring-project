import React from 'react'

const AddEmployee = () => {
  return (
    <div className='flex max-w-2xl mx-auto shadow border-b'>
        <div className='px-8 py-8'>
            <div className='font-thin text-2xl tracking-wider'>
                <h1>Add Employee</h1>
                <div className='items-center justify-center h-14 w-full my-4'>
                    <label className='block text-gray-400 text-sm font-normal'>First Name</label>
                    <input type="text" className='h-10 w-96 border mt-2 px-2 py-2'></input>

                </div>

                <div className='items-center justify-center h-14 w-full my-4'>
                    <label className='block text-gray-400 text-sm font-normal'>Last Name</label>
                    <input type="text" className='h-10 w-96 border mt-2 px-2 py-2'></input>

                </div>

                <div className='items-center justify-center h-14 w-full my-4'>
                    <label className='block text-gray-400 text-sm font-normal'>Email</label>
                    <input type="email" className='h-10 w-96 border mt-2 px-2 py-2'></input>

                </div>

                <div className='items-center justify-center h-14 w-full my-10 space-x-5'>
                   <button className='rounded text-white font-semibold bg-blue-400 hover:bg-blue-700 px-6 py-2'>Save</button>
                   <button className='rounded text-white font-semibold bg-orange-400 hover:bg-orange-700 px-6 py-2'>Clear</button>
                </div>

               
            </div>
        </div>
    </div>
  )
}

export default AddEmployee