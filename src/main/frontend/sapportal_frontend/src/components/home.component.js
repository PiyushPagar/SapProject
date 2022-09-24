import React, { Component } from "react";
import './home.css';
import './../App.css';
import Video from './pages/Video.js';


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
                <Video />
            </div>
        </div>
        </div>

    );
  }
}
