import React, { Component } from "react";
import Navbarforapp from "./pages/Navbarforapp";

import "./done.css"
import Footer from "./pages/Footer";


export default class Logindone extends Component {



  render() {
    return (
      <div>
 <Navbarforapp/>
 <div className="ld-con">
      <a href="/application">Application</a>
 </div>
 <div className="ld-con">
      <a href="/application">Empty</a>
 </div>
 <div className="ld-con">
      <a href="/application">Empty</a>
 </div>
 <Footer/>
      </div>
    );
  }
}
