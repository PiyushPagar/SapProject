import React, { useEffect } from "react";
import ReactDOM from "react-dom";
import { CSSTransition } from "react-transition-group";
import "../Notifications/Modal.css";
const Applicationmodal = (props) => {
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
  });

  return ReactDOM.createPortal(
    <CSSTransition
      in={props.show}
      unmountOnExit
      timeout={{ enter: 0, exit: 300 }}
    >
      <div
        className="modal"
        onClick={props.onClose}
        style={{
          display: "flex",
          alignContent: "center",
          justifyContent: "center",
        }}
      >
        <div className="modal-content" onClick={(e) => e.stopPropagation()}>
          <div className="modal-header">
            <h2 className="modal-title">Choose your activity</h2>
          </div>
          <div className="modal-body" id="divItem">
            <a
              className="btn btn-rounded btn-link"
              style={{
                cursor: "pointer",
                display: "flex",
                alignContent: "center",
                justifyContent: "center",
              }}
              href="/adminlogin"
            >
              Verify Form
            </a>
          </div>
          <br />
          <div className="modal-body" id="divItem">
            <h3>Search Form By</h3>
            <br />
            <a
              className="btn btn-rounded btn-link"
              style={{
                cursor: "pointer",
                display: "flex",
                alignContent: "center",
                justifyContent: "center",
              }}
              href="/searchformbyid"
            >
              Student Id
            </a>
            <a
              className="btn btn-rounded btn-link"
              style={{
                cursor: "pointer",
                display: "flex",
                alignContent: "center",
                justifyContent: "center",
              }}
              href="/searchform"
            >
              User Id
            </a>
            <a
              className="btn btn-rounded btn-link"
              style={{
                cursor: "pointer",
                display: "flex",
                alignContent: "center",
                justifyContent: "center",
              }}
              href="/searchformbyfilter"
            >
              Other
            </a>
          </div>
          <br />
          <div className="modal-body" id="divItem">
            <a
              className="btn btn-rounded btn-link"
              style={{
                cursor: "pointer",
                display: "flex",
                alignContent: "center",
                justifyContent: "center",
              }}
              href="/deleteform"
            >
              Delete Form
            </a>
          </div>
          <div className="modal-footer">
            <button onClick={props.onClose} className="button btn-rounded">
              <i className="fa fa-window-close" aria-hidden="true">
                {" "}
                Close
              </i>
            </button>
          </div>
        </div>
      </div>
    </CSSTransition>,
    document.getElementById("root")
  );
};

export default Applicationmodal;
