import React, { useEffect, useState } from "react";
//import { useNavigate } from "react-router-dom";
import axios from "axios";

const Notification = () => {
  const [data, setData] = useState([]);

  const getData = async () => {
    const res = await axios.get(
      "http://localhost:9190/api/auth/getALLNotifications"
    );

    console.log(res.data.data);
    setData(res.data.data);
  };

  useEffect(() => {
    getData();
  }, []);

  return (
    <div>
      {data.map((ele) => {
        return (
          <div className="box">
            <img
              src={ele.image}
              alt="ffy"
              style={{ width: "200px", height: "200px" }}
            />
            <p>{ele.text}</p>
          </div>
        );
      })}
    </div>
  );
};

export default Notification;
