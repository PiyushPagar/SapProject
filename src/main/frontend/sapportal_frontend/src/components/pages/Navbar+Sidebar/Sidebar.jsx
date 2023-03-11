// // import React from 'react';
// // import './Sidebar.css';
// // import { FaAngleRight, FaAngleLeft } from 'react-icons/fa';
// // import { useState } from 'react';

// // const [showstd, setshowstd] = useState(false)
// // if(localStorage.getItem('role') === "ROLE_USER"){
// //     setshowstd(true)
// // }
// // const [showad, setshowad] = useState(false)
// // if(localStorage.getItem('role') === "ROLE_ADMIN"){
// //     setshowad(true)
// // }
// // class Sidebar extends React.Component {
// //   constructor(props) {
// //     super(props);
// //     this.state = { isNavOpen: true };
// //     this.toggleNav = this.toggleNav.bind(this);
// //   }

// //   toggleNav() {
// //     this.setState({ isNavOpen: !this.state.isNavOpen });
// //   }

// //   render() {
// //     return (
// //       <div className={`vertical-navbar ${this.state.isNavOpen ? 'open' : 'closed'}`}>
// //         <div className="toggle" onClick={this.toggleNav}>
// //           {this.state.isNavOpen ? <FaAngleLeft /> : <FaAngleRight />}
// //         </div>
// //         {this.state.isNavOpen ? (
// //           <ul>
// //             <li><a href="#">Home</a></li>
// //             <li><a href="#">About</a></li>
// //             <li><a href="#">Contact</a></li>
// //             {showstd &&
// //             <li><a href="#">User</a></li>
// //             }
// //             {showad &&
// //             <li><a href="#">Admin</a></li>}
// //           </ul>
// //         ) : null}
// //       </div>
// //     );
// //   }
// // }

// // export default Sidebar;
// //------------------------------------------------------

// import React from "react";
// import "./Sidebar.css";
// // import { FaAngleRight, FaAngleLeft } from "react-icons/fa";

// class Sidebar extends React.Component {
//   constructor(props) {
//     super(props);
//     this.state = { isNavOpen: true };
//     this.toggleNav = this.toggleNav.bind(this);
//   }

//   toggleNav() {
//     this.setState({ isNavOpen: !this.state.isNavOpen });
//   }

//   render() {
//     return (
//       <div
//         className={`vertical-navbar ${
//           this.state.isNavOpen ? "open" : "closed"
//         }`}
//       >
//         <div className="toggle" onClick={this.toggleNav}>
//           {this.state.isNavOpen ? <FaAngleLeft /> : <FaAngleRight />}
//         </div>
//         {this.state.isNavOpen ? (
//           <ul>
//             <li>
//               <a
//                 className="btn btn-rounded btn-link" id="nav-a"
//                 style={{
//                   cursor: "pointer",
//                   display: "flex",
//                   alignContent: "center",
//                   justifyContent: "center",
//                 }}
//                 href="#"
//               >
//                 Home
//               </a>
//             </li>
//             <br />
//             <li>
//               <a
//                 className="btn btn-rounded btn-link" id="nav-a"
//                 style={{
//                   cursor: "pointer",
//                   display: "flex",
//                   alignContent: "center",
//                   justifyContent: "center",
//                 }}
//                 href="#"
//               >
//                 About
//               </a>
//             </li>
//             <br />
//             <li>
//               <a
//                 className="btn btn-rounded btn-link" id="nav-a"
//                 style={{
//                   cursor: "pointer",
//                   display: "flex",
//                   alignContent: "center",
//                   justifyContent: "center",
//                 }}
//                 href="#"
//               >
//                 Contact
//               </a>
//             </li>
//             <br />
//           </ul>
//         ) : null}
//       </div>
//     );
//   }
// }

// export default Sidebar;
