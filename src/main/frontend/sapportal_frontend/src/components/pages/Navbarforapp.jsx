import React, { Component } from "react";

export default function Navbarforapp() {
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
        <div className="right-nav">
          <li>
            <a href="/" className="site-title">
              SRES
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
