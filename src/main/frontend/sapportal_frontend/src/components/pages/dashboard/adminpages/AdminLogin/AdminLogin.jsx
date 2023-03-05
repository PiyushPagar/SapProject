import React, {  } from "react"; //Component - removed
import { useState } from "react";
import Notificationmodal from "../Notifications/NotificationModal";
import "./adminlogin.css";

export default function AdminLogin() {
  const [show, setShow] = useState(false);
  return (<div>
    <div className="ld-main">
      <div className="ld-left">
        <div className="ld-left-item  lr-pd">
          <a href="/" className="site-title ld-center">
            <h2>
              Sanjivani<span className="color-change">SAP</span>
            </h2>
          </a>
        </div>
        <div
          className="ld-down"
          style={{
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
          }}
        >
          <div
            className="ld-d-item "
            style={{ display: "flex", justifyContent: "center" }}
          >
            Application Forms
          </div>
          <div className="ld-d-item ">Home</div>
          <div className="ld-d-item ">Payment</div>
          <div className="ld-d-item ">Course Details</div>
          <div className="ld-d-item " onClick={() => setShow(true)}>
            Notifications
          </div>
          <div className="ld-d-item ">Placement</div>
        </div>
      </div>
      <div className="ld-right">
        <div
          className="lr-color"
          style={{ display: "flex", justifyContent: "center" }}
        >
          <h2 className=" lr-pd ld-center">Welcome Admin</h2>
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
              <a href="/">Logout</a>
            </div>
          </div>
        </div>

        <div className="lr-wrapper"></div>
      </div></div>
      <Notificationmodal title="My Modal" onClose={() => setShow(false)} show={show}>
            </Notificationmodal>
    </div>
  );
}
