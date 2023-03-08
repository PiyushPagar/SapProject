import axios from "axios";
import React from "react";
import { useState } from "react";
const DeleteFormbyId = () => {
  const [sid, setsid] = useState(0);
  const handleid = async (e) => {
    setsid(e.target.value);
  };
  const Deleteform = async () => {
    if (sid !== 0) {
      await axios
        .post(`http://localhost:9190//api/deleteapplicationform/${sid}`)
        .then((res) => {
          alert("The form of Student is deleted");
          window.location.href = "/adminlogin";
        })
        .catch((err) => {
          console.log(err);
        });
    } else {
      alert("Please provide the Student Id");
    }
  };
  return (
    <div>
      <div
        className="container"
        style={{ display: "flex", justifyContent: "center" }}
      >
        <form>
          <h1>Enter the id of Student</h1>
          <br />
          <input
            type="long"
            value={sid}
            name="Id"
            onChange={(e) => handleid(e)}
          />
        </form>
      </div>
      <button
        type="submit"
        onClick={() => Deleteform()}
        className="btn btn-outline-white"
        style={{ display: "flex", justifyContent: "center", margin: "auto" }}
      >
        {" "}
        Delete Form{" "}
      </button>
    </div>
  );
};

export default DeleteFormbyId;
