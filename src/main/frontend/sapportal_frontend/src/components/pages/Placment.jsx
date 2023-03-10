import React from "react";

import "./Placement.css";
// import AOS from 'aos';
// // import 'aos/dist/aos.css';

const Placment = () => {

  return (
    <div>
      <h1 className="center-p">Placement</h1>
      <div className="main-Placement">
        <div data-aos="fade-right"  data-aos-delay="100">
          <div className="con-p">
            <img src="images/pimg.jpeg" className="my-pic" alt="" />
            <h2>Sonar Pratik</h2>
            <h3>Google</h3>
            <p>Web Developer</p>
            <p>1200000 lpa</p>
          </div>
        </div>
        <div data-aos="fade-right" data-aos-delay="300">
          <div className="con-p">
            <img src="images/pimg.jpeg" className="my-pic" alt="" />
            <h2>Sonar Pratik</h2>
            <h3>Google</h3>
            <p>Web Developer</p>
            <p>1200000 lpa</p>
          </div>
        </div>
        <div data-aos="fade-right" data-aos-delay="500">
          <div className="con-p">
            <img src="images/pimg.jpeg" className="my-pic" alt="" />
            <h2>Sonar Pratik</h2>
            <h3>Google</h3>
            <p>Web Developer</p>
            <p>1200000 lpa</p>
          </div>
        </div>
        <div data-aos="fade-right" data-aos-delay="700">
          <div className="con-p">
            <img src="images/pimg.jpeg" className="my-pic" alt="" />
            <h2>Sonar Pratik</h2>
            <h3>Google</h3>
            <p>Web Developer</p>
            <p>1200000 lpa</p>
          </div>
        </div>
      </div>
      <p className="center-p">
        {" "}
        <a href="/seemore" >see more</a>
      </p>
    </div>
  );
};

export default Placment;
