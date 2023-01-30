import React, { Component } from "react";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import {Link} from 'react-router-dom'

import AuthService from "./../../services/auth.service";
import "./../../root.css"
import "./Forget.css"
const required = value => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};

export default class Forget extends Component {
  constructor(props) {
    super(props);
    this.handleForget = this.handleForget.bind(this);
    this.onChangeEmail = this.onChangeEmail.bind(this);

    this.state = {
      Email: "",
      loading : true
    };
  }

  onChangeEmail(e) {
    this.setState({
      Email: e.target.value
    });
  }


  handleForget(e) {
    e.preventDefault();

    this.setState({
      message: "",
      loading: true
    });

    this.form.validateAll();

    if (this.checkBtn.context._errors.length === 0) {
      AuthService.forgotpassword(this.state.Email).then(
        () => {
          this.props.history.push("/verify");
          window.location.reload();
        },
        error => {
          const resMessage =
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();

          this.setState({
            loading: false,
            message: resMessage
          });
        }
      );
    } else {
      this.setState({
        loading: false
      });
    }
  }

  render() {
    return (
      <div className="col-md-12">
        <div className="card card-container">

          <Form
            onSubmit={this.handleForget}
            ref={c => {
              this.form = c;
            }}
          >
            <div className="form-group">
              <Input
                type="text"
                className="form-control"
                name="Email"
                value={this.state.Email}
                onChange={this.onChangeEmail}
                validations={[required]}
                placeholder="Enter Your Email"
              />
            </div>


            <div className="form-group">
              <button
                className="btn btn-primary btn-block"
                id="sub_btn"
                disabled={this.state.loading}
              >
                {this.state.loading && (
                  <span className="spinner-border spinner-border-sm"></span>
                )}
                <span>Get OTP</span>
              </button>
            </div>

            {this.state.message && (
              <div className="form-group">
                <div className="alert alert-danger" role="alert">
                  {this.state.message}
                </div>
              </div>
            )}

            <CheckButton
              style={{ display: "none" }}
              ref={c => {
                this.checkBtn = c;
              }}
            />
          </Form>
        </div>
      </div>
    );
  }
}
