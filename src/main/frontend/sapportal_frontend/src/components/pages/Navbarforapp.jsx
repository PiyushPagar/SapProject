import axios from "axios";
import React from "react";
// import { Switch, Route, Link } from "react-router-dom";

export default function Navbarforapp() {
  const User = localStorage.getItem('username')
  const Onlogout = () => {
    axios.post("http://localhost:9190/api/auth/signout")
    .then((res)=> {
      localStorage.removeItem('token');
      localStorage.removeItem('role');
      localStorage.removeItem("user");
      localStorage.removeItem("username");
    })
  }
  return (
    <nav
      className="nav"
      data-aos="fade-down"
      data-aos-delay="300"
      data-aos-offset="00"
    >
      <ul>
        <div className="left-nav">
          <li>
            <a href="/" className="site-title">
              SRES
            </a>
          </li>
        </div>
        <div className="center-nav">
          <h4 style={{color:"white"}}>Welcome {User}</h4>
        </div>
        <div className="right-nav">
          <li>
            <a href="/" onClick={Onlogout}>
              Logout
            </a>
          </li>
          <li>
            <a href="/" className="site-title">
              <i class="fa fa-user"></i>
            </a>
          </li>
          <li>
            <a href="/" className="site-title">
            <i class="fa fa-user"></i>
            </a>
          </li>
        </div>
      </ul>
    </nav>
  );
}
