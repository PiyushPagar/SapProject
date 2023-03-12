import React from 'react';

const Create = () => {
    return (
        <div className='create-box'>
            <div className="create-con">
<h1 className='t-white'>Create Your Admin</h1>
           <input  className='table-search'  type="text" placeholder='Enter Your Name'/>
           <input  className='table-search'  type="text" placeholder='Phone No'/>
           <select className='table-drop' name="cars" id="cars">
<option value="volvo">Department</option>
<option value="saab">Computer</option>
<option value="saab">Computer</option>
<option value="saab">Computer</option>
<option value="saab">Computer</option>
<option value="saab">Computer</option>

</select>
<div className='btn-table-admin'>

<button>Add Admin</button>
</div>
            </div>
        </div>
    );
}

export default Create;
