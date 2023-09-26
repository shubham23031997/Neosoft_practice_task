import React, { Component } from "react";
import { Link, Navigate } from "react-router-dom";
import EmployeeService from "../service/EmployeeService";
import "./EmployeeForm.css";
class CreateEmployeeComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      firstName: "",
      lastName: "",
      emailId: "",
      registrationSuccessful: false,
    };

    this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
    this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
    this.changeEmailHandler = this.changeEmailHandler.bind(this);
    this.saveEmployee = this.saveEmployee.bind(this);
  }

  changeFirstNameHandler(event) {
    this.setState({ firstName: event.target.value });
  }

  changeLastNameHandler(event) {
    this.setState({ lastName: event.target.value });
  }

  changeEmailHandler(event) {
    this.setState({ emailId: event.target.value });
  }

  saveEmployee(e) {
    e.preventDefault();
    const employee = {
      firstName: this.state.firstName,
      lastName: this.state.lastName,
      emailId: this.state.emailId,
    };
    console.log("employee => " + JSON.stringify(employee));
    EmployeeService.saveEmployee(employee).then((res) => {
      this.setState({ registrationSuccessful: true });
    });
  }

  render() {
    if (this.state.registrationSuccessful) {
      return <Navigate to="/" />;
    }

    return (
      <div>
        <div className="container">
          <div className="row">
            <div className="card col-md-6 offset-md-3">
              <h3 className="text-center">Add new Employee!</h3>
              <div className="card-body">
                <form>
                  <div className="form-group">
                    <label>First Name:</label>
                    <input
                      placeholder="enter first name"
                      name="firstName"
                      className="form-control"
                      value={this.state.firstName}
                      onChange={this.changeFirstNameHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label>Last Name:</label>
                    <input
                      placeholder="enter last name"
                      name="lastName"
                      className="form-control"
                      value={this.state.lastName}
                      onChange={this.changeLastNameHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label>Email-Id:</label>
                    <input
                      placeholder="enter email"
                      name="email"
                      className="form-control"
                      value={this.state.emailId}
                      onChange={this.changeEmailHandler}
                    />
                  </div>
                  <div>
                    <Link
                      className="btn btn-success"
                      onClick={this.saveEmployee}
                    >
                      save
                    </Link>
                    <Link
                      to="/"
                      className="btn btn-danger"
                      style={{ marginLeft: "10px" }}
                    >
                      Cancel
                    </Link>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default CreateEmployeeComponent;
