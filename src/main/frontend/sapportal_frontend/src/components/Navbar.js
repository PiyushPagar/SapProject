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
                </li> <li className="big">
                    <a href="#come-here">Domain4</a>
                </li> <li className="big">
                    <a href="#come-here">Domain5</a></li>
                    <li>
                    <a href="/login">Login</a>
                    {/* <button className="btn  big" type="submit">Login</button> */}
                   </li>
                   <li>
                   <a href="/register">Register</a>
                    {/* <button className="btn big" type="submit">Register</button> */}
                   </li>
            </ul>
        
        </nav>
    )
}




