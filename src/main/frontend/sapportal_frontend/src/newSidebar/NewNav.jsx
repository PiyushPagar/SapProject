import React, { useEffect, useState } from "react";
import "./NewNav.css";
import cross from "./cross.webp";
import menu from "./menu.webp";
import Table from "./table/Table";
import { Link, Route } from "react-router-dom";
import Create from "./table/Create";
import PostPlace from "./table/PostPlace";
import Alluser from "./table/Alluser";
import axios from "axios";
import VerifyForm from "./Verifyform";

const NewNav = (props) => {
  const a = "ROLE_SUPER"  //localStorage.getItem('role');
  //const b = "true";
  const Onlogout = () => {
    axios.post("http://localhost:9190/api/auth/signout").then((res) => {
      localStorage.removeItem("token");
      localStorage.removeItem("role");
      localStorage.removeItem("user");
      localStorage.removeItem("username");
      window.location.href = "/home";
    });
  };
  const [SelectedOption,setSelectedOption] = useState("")
  console.log(SelectedOption)
  // const handleSelect = () => {
  //   console.log("ssssd")
    
  //     // window.location.href = "/newnav/verifyform"
  // }
  // const [nag, setnag] = useState();

  // const callAboutPage = async () => {
  //   try {
  //     const response = await fetch("/time", {
  //       mode: "no-cors",
  //       method: "GET",
  //       headers: {
  //         Accept: "application/json",
  //         "Content-Type": "application/json",
  //       },
  //       credentials: "include",
  //     });
  //     const data = response;
  //     const data1 = await response.json();
  //     console.log();

  //     setnag(data1[0].name);

  //     if (data.status !== 200) {
  //       const error = new Error(response.error);
  //       throw error;
  //     }
  //   } catch (err) {
  //     console.log(err);
  //   }
  // };

  const [op, setOp] = useState("left-nav");
  const [right, setRight] = useState("right-nav98");
  const [picimg, setPicimg] = useState(cross);

  const dothis = () => {
    if (op === "left-nav") {
      setOp("new-left-nav");
      setPicimg(menu);
    } else {
      setOp("left-nav");
      setPicimg(cross);
    }
    if (right === "right-nav98") {
      setRight("new-right-nav98");
    } else {
      setRight("right-nav98");
    }
  };
  useEffect(() => {
    // callAboutPage();
  }, []);

  return (
    <div>
      {/* {nag==="Sachin"? */}
      <div>
        <div className="new-nav">
          <h2>
            Sanjivani
            <span className="color-teal">SAP</span>{" "}
          </h2>
          <h2>Welcome </h2>
          <button onClick={() => Onlogout()}>LogOut</button>
        </div>
        <div className="compo-down">
          <div className={op}>
            <img
              className="cross-img"
              onClick={dothis}
              src={picimg}
              width="10px"
              height="10px"
              alt=""
            />
            {a === "ROLE_ADMIN" ? (
              <p>Admin</p>
            ) : (
              <span>{a === "ROLE_SUPER" ? <p>Super</p> : <p>User</p>}</span>
            )}
            {/*<div className="left-content">Appid</div>*/}
            <div className="left-content">Payment</div>
            <div className="left-content">Course</div>

            {a === "ROLE_ADMIN" ? (
              <div className="left-drop">
                <select
                  className="left-content new-nav-drop"
                  name="cars"
                  id="cars"
                  value={SelectedOption}
                  onChange={ (e) => setSelectedOption(e.target.value)}
                 
                >
                  <option value="App_form">App. Form</option>
                  <option value="ver_form" >Verify Form</option>
                  <option value="ser_form">Search form</option>
                  <option value="del_form">Delete Form</option>
                </select>
                <select
                  className="left-content new-nav-drop"
                  name="cars"
                  id="cars"
                >
                  <option value="notify">Notification</option>
                  <option value="add_notice">Add Notification</option>
                  <option value="del_notice">Delete Notification</option>
                  <option value="upd_notice">Update Notification</option>
                </select>
                <select
                  className="left-content new-nav-drop"
                  name="cars"
                  id="cars"
                >
                  <option value="placed">Placement</option>
                  <option value="add_placed">Add Placement</option>
                </select>
              </div>
            ) : (
              <div>
                {a === "ROLE_SUPER" ? (
                  <>
                    <div >
                      <div className="left-content " style={{display:"flex", justifyContent:"center"}}>
                        <Link className="t-color" to="/newnav/create">
                          Create Admin
                        </Link>
                      </div>
                      <div className="left-content " style={{display:"flex", justifyContent:"center"}}>
                        <Link className="t-color" to="/newnav">
                          Verify User
                        </Link>
                      </div>
                      <div className="left-content " style={{display:"flex", justifyContent:"center"}}>
                        <Link className="t-color" to="/newnav/place">
                          Placement
                        </Link>
                      </div>
                      <div className="left-content " style={{display:"flex", justifyContent:"center"}}>
                        <Link className="t-color" to="/newnav/all">
                          See All Admin
                        </Link>
                      </div>
                    </div>
                    <div className="left-drop">
                      <select
                        className="left-content new-nav-drop"
                        name="cars"
                        id="cars"
                      >
                        <option value="App_form">App. Form</option>
                        <option value="ver_form">Verify Form</option>
                        <option value="ser_form">Search form</option>
                        <option value="del_form">Delete Form</option>
                      </select>
                      <select
                        className="left-content new-nav-drop"
                        name="cars"
                        id="cars"
                      >
                        <option value="notify">Notification</option>
                        <option value="add_notice">Add Notification</option>
                        <option value="del_notice">Delete Notification</option>
                        <option value="upd_notice">Update Notification</option>
                      </select>
                      <select
                        className="left-content new-nav-drop"
                        name="cars"
                        id="cars"
                      >
                        <option value="placed">Placement</option>
                        <option value="add_placed">Add Placement</option>
                      </select>
                      <select
                        className="left-content new-nav-drop"
                        name="cars"
                        id="cars"
                      >
                        <option value="addmin">Admin</option>
                        <option value="cre_addmin">Create Admin</option>
                        <option value="del_addmin">Delete Admin</option>
                      </select>
                    </div>
                  </>
                ) : (
                  <p></p>
                )}
              </div>
            )}
          </div>
          {SelectedOption === "ver_form"? (<>
              <Route exact path="/newnav/verifyform" component={VerifyForm} />
              </>):null}
          <div className={right}>
            {a === "ROLE_STUDENT" ? (
              <p>nothing</p>
            ) : (
              // <Table path="/newnav" />
              
              <Route exact path="/newnav" component={Table} />
            )}
            <Route exact path="/newnav/create" component={Create} />
            <Route exact path="/newnav/place" component={PostPlace} />
            <Route exact path="/newnav/all" component={Alluser} />
            
          </div>
        </div>
      </div>
    </div>
  );
};

export default NewNav;
