import React, { Component } from "react";
<<<<<<< Updated upstream
import './home.css';
import './../App.css';
import Video from './pages/Video.js';
=======
import Footer from "./Footer";

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
<<<<<<< Updated upstream
      <div>
         
                        
						
					
        <div className="row">
            <div className="col-6">
                <Video />
            </div>
        </div>
        </div>

=======
      <div className="container">
        <header className="jumbotron">
         
        </header>
        <Footer/>
      </div>
>>>>>>> Stashed changes
    );
  }
}
