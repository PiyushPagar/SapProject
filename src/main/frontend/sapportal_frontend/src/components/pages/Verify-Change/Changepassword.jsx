import axios from "axios";
import React from "react";
import { useState } from "react";
const Changepassword = () => {
  const [pass, setpass] = useState("");
  const [passn, setpassn] = useState("");
  const Setpassword = async () => {
    if (pass === passn) {
      await axios.post("http://localhost:9190/api/auth/forgotpassword/setnewpassword", {
          email: sessionStorage.getItem("EMAIL"),
          password: passn,
        })
        .then((res) => {
          alert("New password set succesfully");
          sessionStorage.removeItem("EMAIL");
          window.location.href = "/login"
          //window.location = "/login";
        })
        .catch((err) => {
          console.log(err);
        });
    }else {
      alert("Passwords do not match. Re-Enter");
    }
  };
  const handlepassnew = async (e) => {
    setpassn(e.target.value);
  };
  const handlepassword = async (event) => {
    setpass(event.target.value);
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
        <form style={{ display: "flex", alignContent: "center" }}>
          <label>
            {" "}
            Set New Password
            <input
              type="password"
              value={pass}
              name="Password"
              onChange={(e) => handlepassword(e)}
            />
          </label>
          <br />
          <label>
            {" "}
            Confirm New Password
            <input
              type="password"
              value={passn}
              name="Password"
              onChange={(e) => handlepassnew(e)}
            />
          </label>
          <br />
          
        </form>
      </div>
      <button type="submit" onClick={() => Setpassword()} 
          style={{
          display: "flex",
          justifyContent: "center",
          margin: "auto",
          cursor: "pointer",
        }}>
            {" "}
            Change Password{" "}
          </button>
    </div>
  );
};

export default Changepassword;
