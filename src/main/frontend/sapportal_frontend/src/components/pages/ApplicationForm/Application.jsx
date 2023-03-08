import React from "react";
import "./Application.css";
import Footer from "../Footer";
import Navbarforapp from "../Navbarforapp";
import Axios from "axios";

    


const Application = () => {
  const submitHandler = (event) => {
    event.preventDefault();

    var attributes = {
      adhaarCard: event.target.adhaarCard.value,
      branch: event.target.branch.value,
      collegeEmail: event.target.collegeEmail.value,
      contactNumber: event.target.contactNumber.value,
      email: event.target.email.value,
      name: event.target.name.value,
      passoutYear: event.target.passoutYear.value,
      sapModule: event.target.sapModule.value,
      specialization: event.target.specialization.value,
      studentType: event.target.studentType.value,
    };

    const submitHandler = (event)=>{
        event.preventDefault();
        
        var attributes ={ adhaarCard : event.target.adhaarCard.value,
            branch : event.target.branch.value,
            collegeEmail : event.target.collegeEmail.value,
            contactNumber : event.target.contactNumber.value,
            email : event.target.email.value,
            name : event.target.name.value,
            passoutYear : event.target.passoutYear.value,
            sapModule : event.target.sapModule.value,
            specialization : event.target.specialization.value,
            studentType : event.target.studentType.value}

        if(attributes.adhaarCard !== "" && 
        attributes.branch !== "" &&
        attributes.collegeEmail !== "" && 
        attributes.contactNumber !== null &&
        attributes.email !== "" &&
        attributes.name !== "" && 
        attributes.passoutYear !== 0 &&
        attributes.sapModule !== "" &&
        attributes.specialization !== "" &&
        attributes.studentType !== "" ){

            
        Axios.post("http://localhost:9191/api/applicationForm" ,attributes )
        .then(response =>{
            console.log(response);
            window.location.href="/logindone"
           
        })
        .catch((error) => {
          console.log(error);
        });
    } else {
      alert("Invalid");
    }
  };}

  return (
    <div>
      <Navbarforapp />
      <form
        name="sendApplication"
        id="applicationFrom"
        onSubmit={submitHandler}
      >
        <div className="app-con">
          <div className="app-con-from">
            <h1 className="center ">SAP APPLICATION</h1>
            <div className="app-content">
              <input
                type="text"
                placeholder="Enter Adhar Card"
                id="adhaarCard"
              />
              <input type="text" placeholder="Enter branch" id="branch" />
            </div>
            <div className="app-content">
              <input
                type="text"
                placeholder="College Email"
                id="collegeEmail"
              />
              <input
                type="text"
                placeholder="Enter contact Number"
                id="contactNumber"
              />
            </div>
            <div className="app-content">
              <input type="text" placeholder="Enter your Email" id="email" />
              <input type="text" placeholder="Enter your Name" id="name" />
            </div>
            <div className="app-content">
              <input
                type="text"
                placeholder="Enter year of Passing out"
                id="passoutYear"
              />
              <input
                type="text"
                placeholder="Enter SAP Module"
                id="sapModule"
              />
            </div>
            <div className="app-content">
              <input
                type="text"
                placeholder="Enter your specialization"
                id="specialization"
              />
              <input
                type="text"
                placeholder="Enter your Student type"
                id="studentType"
              />
            </div>

            <button className="btn-app">Submit</button>
          </div>
        </div>
      </form>
      <Footer />
    </div>
  );
};

export default Application;
