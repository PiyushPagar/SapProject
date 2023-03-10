import React, { useState } from "react";
import { useHistory } from "react-router-dom";
/*import './App.css';*/
const Verify = () => {
  console.log(sessionStorage.getItem("otp"));
  const [OTP, setOTP] = useState("");
  const history = useHistory();
  const Verifyotp = () => {
    if (sessionStorage.getItem("otp") === OTP) {
      console.log("run");
      history.push("/changepassword");
      sessionStorage.removeItem("otp");
    } else {
      alert("OTP does not match");
    }
  };
  const handleChange = async (event) => {
    console.log(event.target.value);
    setOTP(event.target.value);
  };

  return (
    <div>
      <div
        className="container"
        style={{
          display: "flex",
          alignContent: "center",
          justifyContent: "center",
        }}
      >
        <form>
          <label>
            {" "}
            Enter OTP
            <input
              type="string"
              value={OTP}
              name="OTP"
              onChange={(e) => handleChange(e)}
            />
          </label>
        </form>
      </div>
      <button
        type="submit"
        onClick={Verifyotp}
        style={{
          display: "flex",
          justifyContent: "center",
          margin: "auto",
          cursor: "pointer",
        }}
      >
        Verify OTP{" "}
      </button>
    </div>
  );
};

export default Verify;
