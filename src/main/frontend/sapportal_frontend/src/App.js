import React, { Component } from "react";
import { Switch, Route } from "react-router-dom";

import "./App.css";


import AuthService from "./services/auth.service";

import Login from "./components/login.component";
import Register from "./components/register.component";
import Home from "./components/home.component";
// import Domain from "./components/Domain";
// import Footer from "./components/pages/Footer";
// import AcademicCard from "./components/pages/AcademicCard";

import Application from "./components/pages/ApplicationForm/Application";


// import AuthVerify from "./common/auth-verify";
import EventBus from "./common/EventBus";
import ForgotPassword from "./components/pages/ForgotPassword";
import Verify from "./components/pages/Verify-Change/verify";
// import Body from "./components/Body";
import Seemore from "./components/pages/Seemore";
import Logindone from "./components/pages/dashboard/logindone.component";
import Changepassword from "./components/pages/Verify-Change/Changepassword";
import AdminLogin from "./components/pages/dashboard/adminpages/AdminLogin/AdminLogin";
import Addnotification from "./components/pages/dashboard/adminpages/Notifications/AddNotification/AddNotification";
import UpdateNotification from "./components/pages/dashboard/adminpages/Notifications/UpdateNotification/UpdateNotification";
import DeleteNotification from "./components/pages/dashboard/adminpages/Notifications/DeleteNotification/DeleteNotification";
import DeleteFormbyId from "./components/pages/dashboard/adminpages/ApplicationForms/DeleteForm";
import SearchbyStudentId from "./components/pages/dashboard/adminpages/ApplicationForms/SearchForm/SearchbyStudentId";
import GetbyFilter from "./components/pages/dashboard/adminpages/ApplicationForms/GetByFilter/GetbyFilter";
import SearchbyUserId from "./components/pages/dashboard/adminpages/ApplicationForms/SearchForm/SearchbyUserId";
import withAuth from "./services/WithAuth";
import Navigatebar from "./components/pages/Navbar+Sidebar/Navbar";
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
    // const { currentUser, showModeratorBoard, showAdminBoard } = this.state;

    return (<div>
      <div>
       
       
        

        <div className="container mt-3">
          <Switch>
            <Route exact path={["/", "/home"]} component={Home} />
            <Route exact path="/login" component={Login} />
            <Route exact path="/register" component={Register} />
            <Route exact path="/logindone" component={withAuth(Logindone)} />
            <Route exact path="/seemore" component={Seemore} />
            <Route exact path="/application" component={Application} />
            <Route exact path="/ForgotPassword" component={ForgotPassword} />
            <Route exact path="/verify" component={Verify} />
            <Route exact path="/changepassword" component={Changepassword} />
            <Route exact path="/adminlogin" component={withAuth(AdminLogin)}/>
            <Route exact path="/addnotice" component={withAuth(Addnotification)}/>
            <Route exact path="/updatenotice" component={withAuth(UpdateNotification)}/>
            <Route exact path="/deletenotice" component={withAuth(DeleteNotification)}/>
            <Route exact path="/deleteform" component={withAuth(DeleteFormbyId)}/>
            <Route exact path="/searchformbyid" component={withAuth(SearchbyStudentId)} />
            <Route exact path="/searchformbyuid" component={withAuth(SearchbyUserId)} />
            <Route exact path="/searchbyfilter" component={withAuth(GetbyFilter)} />
            <Route exact path="/nav" component={Navigatebar} />
          </Switch>
        </div>
        
        {/* <AcademicCard /> */}
        </div>
        </div>
       
    );
  }
}


export default App;
