import React, { Component } from "react";

export default function Navbar() {
    return (
        <nav className="nav">
            <ul>
                <li>
                    <a href="/" className="site-title">SRES</a>

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
                    <li>
                    <button className="btn  big" type="submit">Login</button>
                   </li>
                   <li>
                    <button className="btn big" type="submit">Register</button>
                   </li>
            </ul>
        
        </nav>
        

        
     
     
    )
}
