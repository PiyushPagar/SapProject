import React ,{useState} from 'react'
import { Link } from 'react-router-dom'

import './Forget.css'

function ForgotPassword() {
    const [data,setData]=useState(null)
    function getData(val)
    {
      console.warn(val.target.value)
      setData(val.target.value)
      
    }
    return (
    <div className="text-center m-5-auto container" id='Forget'>
            <h2>Reset your password</h2>
            <h5>Enter your email address and we will send you a new password</h5>
            <form action="/login">
                <p>
                    <label id="reset_pass_lbl">Email address</label><br/>
                    <input type="email" name="email" required onChange={getData}/>
                </p>
                <p>
                    <button id="sub_btn" type=''>Send password reset email</button>
                </p>
            </form>
            <footer>
                <p>First time? <Link to="/register">Create an account</Link>.</p>
                <p><Link to="/">Back to Homepage</Link>.</p>
            </footer>
        </div>
        )
}
export default ForgotPassword;