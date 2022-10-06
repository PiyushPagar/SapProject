import React, { Component } from "react";
import { Switch, Route, Link } from "react-router-dom";

import "./App.css";


import AuthService from "./services/auth.service";

import Login from "./components/login.component";
import Register from "./components/register.component";
import Home from "./components/home.component";
import Logindone from "./components/logindone.component";
import Domain from "./components/Domain";
import Footer from "./components/pages/Footer";


// import AuthVerify from "./common/auth-verify";
import EventBus from "./common/EventBus";
import ForgotPassword from "./components/pages/ForgotPassword";
import Navbar from "./components/Navbar";
import Body from "./components/Body";

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
       
       
        <Navbar />
        

        <div className="container mt-3">
          <Switch>
            <Route exact path={["/", "/home"]} component={Home} />
            <Route exact path="/login" component={Login} />
            <Route exact path="/register" component={Register} />
            <Route exact path="/logindone" component={Logindone} />
            <Route exact path="/logindone" component={Logindone} />
            <Route exact path="/ForgotPassword" component={ForgotPassword} />
          </Switch>
        </div>
        
        
        </div>
          <Footer />
        </div>
       
    );
  }
}


export default App;
