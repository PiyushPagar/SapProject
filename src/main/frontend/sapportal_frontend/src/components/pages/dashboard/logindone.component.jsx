import React, { Component } from "react";

import "./done.css";

export default class Logindone extends Component {
  render() {
    return (
      <div className="ld-main">
        <div className="ld-left">
          <div className="ld-left-item  lr-pd">
            <a href="/" className="site-title ld-center">
              <h2>
                Sanjivani<span className="color-change">SAP</span>
              </h2>
            </a>
          </div>
          <div className="ld-down">
            <div className="ld-d-item">Profile</div>
            <div className="ld-d-item">Home</div>
            <div className="ld-d-item">Payment</div>
            <div className="ld-d-item">Course Details</div>
            <div className="ld-d-item">Extra</div>
            <div className="ld-d-item">Extra</div>
          </div>
        </div>
        <div className="ld-right">
          <div className="lr-color" style={{display :'flex', justifyContent : 'center'}}>
            <h2 className=" lr-pd ld-center">Welcome Student</h2>
            <div className="lr" style={{display :'flex',justifyContent : 'center', marginLeft : '120px'}}>
          <div className="btn btn-outline-white btn-rounded" style={{display :'flex',justifyContent : 'center',marginTop:'5px',marginBottom:'5px'}}>
            <a href="/">Logout</a>
          </div>
          <div className="btn btn-outline-white btn-rounded">
              <span className="material-symbols-outlined" >notifications</span>
          </div>
          </div>
          </div>
          
          <div className="lr-wrapper"></div>
        </div>
      </div>
    );
  }
}
