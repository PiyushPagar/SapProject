import React, { Component } from "react";
import { Switch, Route, Link } from "react-router-dom";

import "./App.css";


import AuthService from "./services/auth.service";

import Login from "./components/login.component";
import Register from "./components/register.component";
import Home from "./components/home.component";
import Domain from "./components/Domain";
import Footer from "./components/pages/Footer";
import AcademicCard from "./components/pages/AcademicCard";
import Application from "./components/Application"


// import AuthVerify from "./common/auth-verify";
import EventBus from "./common/EventBus";
import ForgotPassword from "./components/pages/ForgotPassword";
import Navbar from "./components/Navbar";
import Body from "./components/Body";
import Seemore from "./components/pages/Seemore";
import Logindone from "./components/pages/dashboard/logindone.component";
import verify from "./components/pages/dashboard/Verify+Change/verify";
// const app = require("express");
// const cors = require("cors")
// app.use(cors());

class App extends Component {
  constructor(props) {
    super(props);
    this.logOut = this.logOut.bind(this);

    this.state = {
      showModeratorBoard: false,
      showAdminBoard: false,
      currentUser: undefined,
    };
  }

  componentDidMount() {
    const user = AuthService.getCurrentUser();

    if (user) {
      this.setState({
        currentUser: user,
        showModeratorBoard: user.roles.includes("ROLE_MODERATOR"),
        showAdminBoard: user.roles.includes("ROLE_ADMIN"),
      });
    }
    
    EventBus.on("logout", () => {
      this.logOut();
    });
  }

  componentWillUnmount() {
    EventBus.remove("logout");
  }

  logOut() {
    AuthService.logout();
    this.setState({
      showModeratorBoard: false,
      showAdminBoard: false,
      currentUser: undefined,
    });
  }

  render() {
    const { currentUser, showModeratorBoard, showAdminBoard } = this.state;

    return (<div>
      <div>
       
       
        

        <div className="container mt-3">
          <Switch>
            <Route exact path={["/", "/home"]} component={Home} />
            <Route exact path="/login" component={Login} />
            <Route exact path="/register" component={Register} />
            <Route exact path="/logindone" component={Logindone} />
            <Route exact path="/seemore" component={Seemore} />
            <Route exact path="/application" component={Application} />
            <Route exact path="/ForgotPassword" component={ForgotPassword} />
            <Route exact path="/verify" component={verify}></Route>
          </Switch>
        </div>
        
        {/* <AcademicCard /> */}
        </div>
        </div>
       
    );
  }
}


export default App;
