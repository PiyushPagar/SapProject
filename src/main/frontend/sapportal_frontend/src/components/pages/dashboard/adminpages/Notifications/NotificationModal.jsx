import React, { useEffect } from "react";
import ReactDOM from "react-dom";
import { CSSTransition } from "react-transition-group";
import "./Modal.css";
const Notificationmodal = (props) => {
  const closeOnEscapeKeyDown = (e) => {
    if ((e.charCode || e.keyCode) === 27) {
      props.onClose();
    }
  };

  useEffect(() => {
    document.body.addEventListener("keydown", closeOnEscapeKeyDown);
    return function cleanup() {
      document.body.removeEventListener("keydown", closeOnEscapeKeyDown);
    };
  }, []);

  return ReactDOM.createPortal(
    <CSSTransition
      in={props.show}
      unmountOnExit
      timeout={{ enter: 0, exit: 300 }}
    >
      <div className="modal" onClick={props.onClose}
      style={{ display: "flex", alignContent:"center", justifyContent:"center"}}>
        <div className="modal-content" onClick={(e) => e.stopPropagation()}>
          {/* <div className="modal-header">
                <h4 className="modal-title">{props.title}</h4>
              </div> */}
          <div className="modal-body" id="divItem">
            <a className="btn btn-rounded btn-link"
            style={{cursor: 'pointer', display: "flex", alignContent:"center", justifyContent:"center"}} href="/addnotice">
              Add Notification
            </a>
          </div>
          <br />
          <div className="modal-body" id="divItem">
            <a className="btn btn-rounded btn-link"
            style={{cursor: 'pointer',display: "flex", alignContent:"center", justifyContent:"center"}} href="/updatenotice">
              Update Notification
            </a>
          </div>
          <br />
          <div className="modal-body" id="divItem">
            <a className="btn btn-rounded btn-link"
            style={{cursor: 'pointer',display: "flex", alignContent:"center", justifyContent:"center"}} href="/deletenotice">
             Delete Notification
            </a>
          </div>
          <div className="modal-footer">
            <button onClick={props.onClose} className="button btn-rounded">
              Close
            </button>
          </div>
        </div>
      </div>
    </CSSTransition>,
    document.getElementById("root")
  );
};

export default Notificationmodal;
