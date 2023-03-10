import React from "react";
import "./NewBody.css";
// import { useTransition, animated } from "react-spring";
// import { useState, useEffect } from "react";
const NewBody = () => {
  // const [isVis, setIsVis] = useState(true);

  // const transition = useTransition(isVis, {
  //   from: { x: -100, y: 300, opacity: 0 },
  //   enter: { x: 0, y: 0, opacity: 1 },
  //   leave: { x: -100, y: 300, opacity: 0 },
  // });

  // const useThiss = () => {
  //   setIsVis((v) => !v);
  // };
  // setInterval(() => {}, 3000);

  return (
    <div className="new-con">
      {/* {transition((style, item) =>
        item ? (
          <animated.div style={style} className="item"> */}
            <div className="right "  data-aos="fade-down">
              <div className="forimg">
                <img className="san-img" src="images/mylogo.png" alt="" />
              </div>
              <div className="content-right">
                <h1 className="doit">
                  Sanjivani College Of <br /> Engneering
                </h1>
              </div>
            </div>
          {/* </animated.div>
        ) : (
          ""
        )
      )} */}

      {/* <div className="left">
                <img src="images/SAP_logo.webp" alt="" />
            </div> */}
    </div>
  );
};

export default NewBody;
