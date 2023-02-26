import axios from 'axios';
import React, { useEffect, useState } from 'react'
import {useParams} from 'react-router-dom'
/*import './App.css';*/
const Verify = () => {
   console.log(sessionStorage.getItem('otp'))
   const Verifyotp =() =>{
    
   }

   return (
    <div className='container'>
        <form >
          <label> Email
            <input type = "email"  name = "Email" />
          </label>
          <button type = "submit" > 
           OTP </button>
        </form>
    </div>
   )
   
}
   
export default Verify;