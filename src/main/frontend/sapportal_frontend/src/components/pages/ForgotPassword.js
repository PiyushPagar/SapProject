import React, { Component } from 'react';
import axios from "axios"; 
import "./Forget.css";
class ForgotPassword extends Component {
  state = {
    Email: '',
  };
/* This is where the magic happens 
*/
handleSubmit = event => {
    event.preventDefault();
    const mail = {
      Email: this.state.Email
    }
    axios.post('https://localhost:9190/api/auth/forgotpassword/' + { mail })
      .then(res=>{
        console.log(res);
        console.log(res.data);
        window.location = "/verify" //This line of code will redirect you once the submission is succeed
      })
  }
handleChange = event =>{
    this.setState({ Email: event.target.value});
  }
render() {
    return (
      <div className='container'>
        <form >
          <label> Email
            <input type = "email" name = "Email" onChange= {this.handleChange}/>
          </label>
          <button type = "submit" onClick = { this.handleSubmit }> Send OTP </button>
        </form>
    </div>
    );
  }
}
export default ForgotPassword;