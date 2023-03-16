import React from "react";
import "./Footer.css";

export default function Footer() {
  const newLocal = (
    <a href="/" className="link-1">
      Home
    </a>
  );
  return (
    <div>
      <footer
        className="footer-distributed"
        data-aos="fade-up"
        data-aos-delay="300"
        data-aos-offset="50"
      >
        <div className="footer-left">
          <h3>
            Sanjivani<span>SAP</span>
          </h3>

          <p className="footer-links">
            {newLocal}

            {/* <a href="#">Blog</a>
				
					<a href="#">Pricing</a> */}

            <a href="#">About</a>

            <a href="#">Faq</a>

            <a href="#">Contact</a>
          </p>

          <p className="footer-company-name">
            Sanjivani College of Engineering,
            <br />
            Kopargaon.
          </p>
        </div>

        <div className="footer-center">
          <div>
            <i className="fa fa-map-marker"></i>
            <p>
              <span>Station Rd, opposite to Sanjivani Factory,</span>{" "}
              <span> Singnapur, Kopargaon,</span> Maharashtra 423603
            </p>
          </div>

          <div>
            <i className="fa fa-phone"></i>
            <p>+91 9130191301</p>
          </div>

          <div>
            <i className="fa fa-envelope"></i>
            <p>
              <a href="mailto:support@company.com">support@company.com</a>
            </p>
          </div>
        </div>

        <div className="footer-right">
          <p className="footer-company-about">
            <span>About the College</span>
            Lorem ipsum dolor sit amet, consectateur adispicing elit. Fusce
            euismod convallis velit, eu auctor lacus vehicula sit amet.
          </p>

          <div className="footer-icons">
            <a href="#">
              <i className="fa fa-facebook"></i>
            </a>
            <a href="#">
              <i className="fa fa-twitter"></i>
            </a>
            <a href="#">
              <i className="fa fa-linkedin"></i>
            </a>
            <a href="#">
              <i className="fa fa-github"></i>
            </a>
          </div>
        </div>
      </footer>
    </div>
  );
}
