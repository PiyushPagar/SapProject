import axios from "axios";
import React from "react";
import { useState } from "react";

const SearchbyUserId = () => {
  const [Uid, setUid] = useState(0);
  const [show, setshow] = useState(false);
  const handleStdid = async (e) => {
    setUid(e.target.value);
  };
  const [data, setData] = useState([]);

  const GetForm = async () => {
    if (Uid !== 0) {
      const res = await axios
        .post(`http://localhost:9190/api/getapplicationformbyid/${Uid}`)
        .then(setshow(true));
      setData(res.data).catch((err) => {
        console.log(err);
      });
    } else {
      alert("Please fill the Student Id");
    }
  };

  return (
    <div>
      <a
        className="btn btn-link btn-rounded"
        style={{
          float: "right",
          display: "flex",
          justifyContent: "center",
          marginRight: "25px",
          cursor: "pointer",
        }}
        href="/adminlogin"
      >
        Back to Dashboard
      </a>
      <div
        className="container"
        style={{ display: "flex", justifyContent: "center" }}
      >
        <form>
          <h1>Enter the User Id</h1>
          <br />
          <input
            type="long"
            value={Uid}
            name="Id"
            onChange={(e) => handleStdid(e)}
          />
        </form>
      </div>
      <button
        type="submit"
        onClick={() => GetForm()}
        className="btn btn-outline-white"
        style={{
          display: "flex",
          justifyContent: "center",
          margin: "auto",
          cursor: "pointer",
        }}
      >
        {" "}
        Get Form{" "}
      </button>

      {show && (
        <>
          <div className="container">
            <div>
              <h6>Name : {data.name}</h6>
            </div>
          </div>
          <div></div>
        </>
      )}
    </div>
  );
};

export default SearchbyUserId;
