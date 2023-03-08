import axios from "axios";
import React from "react";
import { useState } from "react";
const DeleteNotification = () => {
  const [did, setdid] = useState(0);
  const handleid = async (e) => {
    setdid(e.target.value);
  };
  const Deletenotice = async () => {
    if (did !== 0) {
      await axios
        .post(`http://localhost:9190/deleteNotificationData/${did}`)
        .then((res) => {
          alert("The notification is deleted");
          window.location.href = "/adminlogin";
        })
        .catch((err) => {
          console.log(err);
        });
    } else {
      alert("Please fill all the details");
    }
  };
  return (
    <div>
      <div
        className="container"
        style={{ display: "flex", justifyContent: "center" }}
      >
        <form>
          <h1>Enter the id of Notification to delete</h1>
          <br />
          <input
            type="long"
            value={did}
            name="Id"
            onChange={(e) => handleid(e)}
          />
        </form>
      </div>
      <button
        type="submit"
        onClick={() => Deletenotice()}
        className="btn btn-outline-white"
        style={{ display: "flex", justifyContent: "center", margin: "auto" }}
      >
        {" "}
        Delete notification{" "}
      </button>
    </div>
  );
};

export default DeleteNotification;
