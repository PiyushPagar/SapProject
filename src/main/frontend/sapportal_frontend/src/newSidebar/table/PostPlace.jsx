import React from 'react';

const PostPlace = () => {
    return (
        <div className='create-box'>
            <div className="create-con">
<h1 className='t-white'>POST PLACEMENT</h1>

<form>
  <input type="file" id="myFile" name="filename"/>
  <input type="submit"/>
</form>

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

export default PostPlace;
