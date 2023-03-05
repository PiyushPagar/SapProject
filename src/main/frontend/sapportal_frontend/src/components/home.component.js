import React, { Component } from "react";
import './home.css';
import './../App.css';
// import Video from './pages/Video.js';
// import Body from "./Body";
import Domain from "./Domain";
import Placment from "./pages/Placment";
import NewBody from "./pages/NewBody";
import Navbar from "./Navbar";
import Footer from "./pages/Footer";
// import AcademicCard from "./pages/AcademicCard";
import Iframe from "./pages/iframe/Iframe";

export default class Home extends Component {
  constructor(props) {
    super(props);

    this.state = {
      content: ""
    };
  }


  render() {



    return (
      <div>
        <Navbar/>

        <div className="row">
            <div className="col-6">
                
            </div>
        </div>


      <div className="container">
        <header className="jumbotron">
         
        </header>
      
        {/* <Body /> */}
        <NewBody/>
        <hr data-aos="fade-right" data-aos-delay="300" data-aos-offset="120"/>
        <Iframe/>
        <hr data-aos="fade-right" data-aos-delay="300" data-aos-offset="120"/>

        <Domain />
        <hr data-aos="fade-right" data-aos-delay="300" data-aos-offset="120"/>
      </div>
      <Placment/>

      <Footer/>

      {/* <AcademicCard /> */}

      {/* <Footer/> */}

      </div>
    );
  }
}
