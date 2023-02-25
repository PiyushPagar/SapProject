import React, { Component, useState } from 'react';
import axios from "axios"; 
import "./Forget.css";
// const ForgotPassword =() => {


// } 
// const [email,setemail] = useState('');
// const handleChange = (ele) => {
//   console.log(ele);
  
// }
// return (
//   <div>
//     <form style={{display : 'flex', justifyContent: 'right', marginRight : '80px', marginBottom:'10px'}}>
//           <input type="email" placeholder="Enter your Email" 
//                   onChange={(e)=> setemail(e.target.value)} 
//           />
//         </form>
//   </div>
//)
class ForgotPassword extends Component {
  state = {
    email: '',
  };

/* This is where the magic happens 
*/
handleSubmit = event => {
    event.preventDefault();
    const mail = this.state.email
    console.log(mail)
    axios.post(`https://localhost:9190/api/auth/forgotpassword/${mail}`)
      .then(res=>{
        console.log(res);
        console.log(res.data);
        window.location = "/verify" //This line of code will redirect you once the submission is succeed
      }).catch(err=>{
        console.log(err);
      })
  }
handleChange = event =>{
  console.log(event.target.value)
    this.setState({ email: event.target.value});
    
  }
render() {
    return (
      <div className='container'>
        <form >
          <label> Email
            <input type = "email" value = {this.state.email} name = "Email" onChange = {(e)=>this.handleChange(e)}/>
          </label>
          <button type = "submit" onClick = { (e)=>this.handleSubmit(e) }> Send OTP </button>
        </form>
    </div>
    );
  }
}
export default ForgotPassword;