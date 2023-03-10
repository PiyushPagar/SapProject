import axios from "axios";
import React, { Component } from "react";

import "./done.css";

export default class Logindone extends Component {
  render() {
    const Onlogout = () => {
      axios.post("http://localhost:9190/api/auth/signout")
      .then((res)=> {
        localStorage.removeItem('token');
        localStorage.removeItem('role');
        localStorage.removeItem("user");
      })
    }
    console.log(sessionStorage.getItem("rest"));
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
            <div className="ld-d-item"><a href="/application">Application Form</a></div>
            <div className="ld-d-item">Payment</div>
            <div className="ld-d-item">Course Details</div>
            <div className="ld-d-item">Extra</div>
            <div className="ld-d-item">Extra</div>
          </div>
        </div>
        <div className="ld-right">
          <div
            className="lr-color"
            style={{ display: "flex", justifyContent: "center" }}
          >
            <h2 className=" lr-pd ld-center">Welcome Student</h2>
            <div
              className="lr"
              style={{
                display: "flex",
                justifyContent: "center",
                alignItems: "center",
                marginLeft: "120px",
              }}
            >
              <div
                className="btn btn-outline-white btn-rounded "
                style={{
                  display: "flex",
                  justifyContent: "center",
                  cursor: "pointer",
                  height: "35px",
                }}
              >
                <a href="/" onClick={Onlogout}>Logout</a>
              </div>
              <div
                className="btn btn-outline-white rounded-btn"
                style={{
                  display: "flex",
                  justifyContent: "center",
                  height: "35px",
                }}
              >
                <span className="material-symbols-outlined">notifications</span>
              </div>
            </div>
          </div>

          <div className="lr-wrapper"></div>
        </div>
      </div>
    );
  }
}
