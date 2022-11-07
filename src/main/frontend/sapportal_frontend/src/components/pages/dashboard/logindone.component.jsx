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
          <div className="lr-color">
            <h2 className=" lr-pd ld-center">Welcome xyz</h2>
          </div>
          <div className="lr-btn">
            <a href="/">Logout</a>
          </div>
          <div className="lr-wrapper"></div>
        </div>
      </div>
    );
  }
}
