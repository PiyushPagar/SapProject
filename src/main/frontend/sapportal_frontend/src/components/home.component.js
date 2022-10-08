import React, { Component } from "react";
import './home.css';
import './../App.css';
import Video from './pages/Video.js';
import Body from "./Body";
import Domain from "./Domain";





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
        
        <div className="row">
            <div className="col-6">
                
            </div>
        </div>


      <div className="container">
        <header className="jumbotron">
         
        </header>
      
        <Body />
        <Domain />
      </div>
      
      </div>
    );
  }
}
