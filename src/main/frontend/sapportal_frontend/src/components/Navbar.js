import React, { Component } from "react";
import { Switch, Route, Link } from "react-router-dom";

export default function Navbar() {
    return (
        <nav className="nav">
            <ul>
                <li className="big">
                    <Link to={"/"} className="big">
                      Home
                    </Link>
            </li>
                <li className="big">
                    <a href="/pricig">Domain0</a>
                </li>
               
                <li className="big">
                    <a href="/about">Domain1</a>
                </li>
                <li className="big">
                    <a href="/about">Domain2</a>
                </li>
                <li className="big">
                    <a href="/about">Domain3</a>
                </li> <li className="big">
                    <a href="/about">Domain4</a>
                </li> <li className="big">
                    <a href="/about">Domain5</a></li>
                    
                    <li className="big">
                            <Link to={"/login"} className="big">
                              Login
                            </Link>
                    </li>
                   
                    <li className="nav-item">
                        <Link to={"/register"} className="nav-link">
                          Sign Up
                        </Link>
                      </li>
            </ul>
        
        </nav>
        

        
     
     
    )
}
