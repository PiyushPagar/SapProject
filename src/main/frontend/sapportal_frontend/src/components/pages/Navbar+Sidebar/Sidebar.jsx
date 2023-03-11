
import React, { useState } from "react";
import "./Sidebar.css";
import { FaAngleRight, FaAngleLeft } from "react-icons/fa";
import { Link } from "react-router-dom";

class Sidebar extends React.Component {
  constructor(props) {
    super(props);
    this.state = { 
      isNavOpen: true,
      showDropdown: false,
    };
    this.toggleNav = this.toggleNav.bind(this);
    this.toggleDropdown = this.toggleDropdown.bind(this);
  }

  toggleNav() {
    this.setState({ isNavOpen: !this.state.isNavOpen });
  }
  

  toggleDropdown() {
    this.setState({showDropdown: !this.state.showDropdown});
  };

  render() {
    return (
      <div
        className={`vertical-navbar ${
          this.state.isNavOpen ? "open" : "closed"
        } navbar ${this.state.showDropdown ? "navbar-expanded" : ""}`}
      >
        <div className="toggle" onClick={this.toggleNav} style={{marginLeft:"2px"}}>
          {this.state.isNavOpen ? <FaAngleLeft /> : <FaAngleRight />}
        </div><br />
        {this.state.isNavOpen ? (
          <ul>
            <li className="dropdown">
              <button
                className="btn btn-rounded btn-link dropbtn " //id="nav-a" 
                onClick={this.toggleDropdown} 
                style={{
                  cursor: "pointer",
                  display: "flex",
                  alignContent: "center",
                  justifyContent: "center",
                }}
                
              >ApplicationForms</button>
                <ul className="dropdown-menu">
            <li>
              <a href="#">Option 1</a>
            </li>
            <li>
              <a href="#">Option 2</a>
            </li>
            <li>
              <a href="#">Option 3</a>
            </li>
          </ul>
              
              
            </li>
            <br /><br />
            <li>
              <button
                className="btn btn-rounded btn-link" id="nav-a"
                style={{
                  cursor: "pointer",
                  display: "flex",
                  alignContent: "center",
                  justifyContent: "center",
                }}
                
              >
                About
              </button>
            </li>
            <br />
            <li>
              <button
                className="btn btn-rounded btn-link" id="nav-a"
                style={{
                  cursor: "pointer",
                  display: "flex",
                  alignContent: "center",
                  justifyContent: "center",
                }}
                href="#"
              >
                Contact
              </button>
            </li>
            <br />
          </ul>
        ) : null}
      </div>
    );
  }
}

export default Sidebar;
