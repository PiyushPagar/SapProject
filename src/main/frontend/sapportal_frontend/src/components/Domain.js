import React from "react";
import AOS from "aos";
import "aos/dist/aos.css";
// import styled from 'styled-components';
import "./Domain.css";
function Domain() {
  AOS.init({
    duration: 5000,
    offset: 300,
    once: true,
  });
  return (
    <section className="services" id="services">
      <div className="content">
        <div className="title">
          <span id="come-here">Domain</span>
        </div>
        <div className="boxes">
          <div
            className="box"
            data-aos="fade-down-right"
            data-aos-duration="2000"
            data-aos-delay="1000"
          >
            <div className="icon">
              <i className="fas fa-desktop"></i>
            </div>
            <div className="topic">ABAP</div>
            <p>
              Advanced Business Application Programming <br></br> ABAP is a high
              level programming language created by SAP that helps large
              corporations to customize the SAP ERP. ABAP can help customize
              workflows for financial accounting, materials management, asset
              management, and all other modules of SAP. SAP’s current
              development platform NetWeaver also supports both ABAP and Java.
              The ABAP full form in SAP is Advanced Business Application and
              Programming for data Processing.
            </p>
          </div>
          <div className="box" data-aos="fade-down-right" data-aos-delay="300">
            <div className="icon">
              <i className="fas fa-brush"></i>
            </div>
            <div className="topic">MM</div>
            <p>
              {" "}
              SAP MM (Material Management) Module is an SAP ERP component that
              helps organizations with material management, inventory
              management, and warehouse management in the supply chain process.
              It is part of SAP ECC’s logistics functions, consisting of several
              components and sub-components. The most prominent and widely used
              components are Master Data, Purchasing, and Inventory{" "}
            </p>
          </div>
          <div className="box" data-aos="fade-down-right" data-aos-delay="500">
            <div className="icon">
              <i className="fas fa-chart-line"></i>
            </div>
            <div className="topic">PP</div>
            <p>
              Planning (PP) is the process of aligning demand with manufacturing
              capacity to create production and procurement schedules for
              finished products and component materials. SAP PP is an important
              module of SAP. It tracks and makes a record of the manufacturing
              process flows, for example, the planned and actual costs. Also,
              goods movements from the conversion of raw material to
              semi-finished goods.
            </p>
          </div>
          <div
            className="box"
            data-aos="fade-down-right"
            data-aos-delay="100"
            data-aos-offset="120"
          >
            <div className="icon">
              <i className="fab fa-wordpress"></i>
            </div>
            <div className="topic">SD</div>
            <p>
              SAP Sales and Distribution (SAP SD) is a core functional module in
              SAP ERP Central Component (ECC) that allows organizations to store
              and manage customer- and product-related data. Organizations use
              this data to manage all of the sales orders, shipping, billing,
              and invoicing of their goods and services.{" "}
            </p>
          </div>
          <div
            className="box"
            data-aos="fade-down-right"
            data-aos-delay="300"
            data-aos-offset="120"
          >
            <div className="icon">
              <i className="fas fa-cloud"></i>
            </div>
            <div className="topic">FICO</div>
            <p>
              SAP FICO is a module of SAP ERP which is used for financial
              reporting both externally and internally. The objective is to
              record all financial transactions posted by an entity and produce
              accurate financial statements at the end of the trading period.
              The SAP FICO full form is FI (Financial Accounting) and CO
              (Controlling).{" "}
            </p>
          </div>
          <div
            className="box"
            data-aos="fade-down-right"
            data-aos-delay="500"
            data-aos-offset="120"
          >
            <div className="icon">
              <i className="fas fa-tablet-alt"></i>
            </div>
            <div className="topic">HR/HCM </div>
            <p>
              Human Resource SAP Human Capital Management (SAP HCM) is an
              important module in SAP. It is also known as SAP Human Resource
              Management System (SAP HRMS) or SAP Human Resource (HR). SAP HR
              software allows you to automate record-keeping processes. It is an
              ideal framework for the HR department to take advantage of the
              administration and payroll documents.
            </p>
          </div>
        </div>
      </div>
    </section>
  );
}

export default Domain;
