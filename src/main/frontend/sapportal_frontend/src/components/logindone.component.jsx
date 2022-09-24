import React, { Component } from "react";



export default class Logindone extends Component {
  constructor(props) {
    super(props);

    this.state = {
      content: ""
    };
  }


  render() {
    return (
      <div className="container">
        <header className="jumbotron">
          <h3>login sucess</h3>
        </header>
      </div>
    );
  }
}
