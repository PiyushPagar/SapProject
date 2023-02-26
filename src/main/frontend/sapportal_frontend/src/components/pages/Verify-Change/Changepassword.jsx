import axios from "axios";
import React from "react";
import { useState } from "react";
import { useHistory } from 'react-router-dom';
const Changepassword =() =>{
    const history = useHistory();
    const [pass, setpass]  = useState('');
    const [passn, setpassn]  = useState('');
    const Setpassword = async () => {
        if(pass === passn){
        axios.post(`http://localhost:9190/api/auth/forgotpassword/setnewpassword`,{
                email : sessionStorage.getItem('EMAIL'),
                password : passn,
        })
        .then((res) =>{
          console.log(res);
          history.push('/login')
          sessionStorage.removeItem('EMAIL')
        }).catch(err=>{
          console.log(err);
        })
    }
        else{
            alert("Passwords do not match. Re-Enter")
        }
}
    const handlepassnew = async (e) => {
        setpassn(e.target.value)
    }
        const handlepassword = async (event) =>{
            setpass(event.target.value);
              
            }

    return(
        <div className='container' style={{display:'flex',alignContent:'center'}}>
        <form >
          <label> Set New Password
            <input type = "password" value = {pass} name = "Password" onChange = {(e) => handlepassword(e)}/>
          </label><br />
          <label> Confirm New Password
            <input type = "password" value = {passn} name = "Password" onChange = {(e)=> handlepassnew(e)}/>
          </label><br />
          <button type = "submit" onClick = { Setpassword }> Change Password </button>
        </form>
    </div>
    )
}

export default Changepassword