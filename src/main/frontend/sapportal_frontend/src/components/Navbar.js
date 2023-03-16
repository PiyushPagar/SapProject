import React, {  } from "react"; 

export default function Navbar() {
  return (
    <nav className="nav" data-aos="fade-down" data-aos-delay="300" data-aos-offset="00">
      <ul>
        <div className="left-nav" style={{backgroundColor:"black"}}>
          <li>
            <a href="/" className="site-title">
              <h2>
                Sanjivani<span className="color-change">SAP</span>
                </h2>
            </a>
          </li>
          {/* <li className="big">
            <a href="#come-here">Domain0</a>
          </li>
          <li className="big">
            <a href="#come-here">Domain1</a>
          </li>
          <li className="big">
            <a href="#come-here">Domain2</a>
          </li>
          <li className="big">
            <a href="#come-here">Domain3</a>
          </li>{" "}
          <li className="big">
            <a href="#come-here">Domain4</a>
          </li>{" "}
          <li className="big">
            <a href="#come-here">Domain5</a>
          </li>*/}
        </div> 

        <div className="right-nav" style={{marginLeft : "800px"}}>
          <li>
            <a href="/login">Login</a>
          </li>
          <li>
            <a href="/register">Register</a>
          </li>

          <input className="nav-input" type="text" placeholder="Search" />
        </div>
      </ul>
    </nav>
  );
}
