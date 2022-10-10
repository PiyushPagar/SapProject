import React, { Component } from "react";
import './home.css';
import './../App.css';
import Video from './pages/Video.js';
import Body from "./Body";
import Domain from "./Domain";
<<<<<<< Updated upstream
import Placment from "./pages/Placment";
import NewBody from "./pages/NewBody";
=======
import Navbar from "./Navbar";
import Footer from "./pages/Footer";
import AcademicCard from "./pages/AcademicCard";


>>>>>>> Stashed changes





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
        <hr />
        <Domain />
        <hr />
      </div>
<<<<<<< Updated upstream
      <Placment/>
=======
      <AcademicCard />

      <Footer/>
>>>>>>> Stashed changes
      </div>
    );
  }
}
