import React, { Component } from "react";

class RegistrationForm extends Component {
  constructor(props) {
    super(props);

    this.state = {
      username: "",
      email: "",
      password: "",
    };
  }

  handleInputChange = (e) => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  };

  handleSubmit = async (e) => {
    e.preventDefault();

    const registrationData = {
      username: this.state.username,
      email: this.state.email,
      password: this.state.password,
    };

    try {
      const response = await fetch("http://localhost:8181/auth/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(registrationData),
      });

      if (response.ok) {
        // Registration was successful, you can redirect or perform other actions.
        console.log("Registration successful");
      } else {
        // Registration failed, handle the error.
        console.error("Registration failed");
      }
    } catch (error) {
      // Handle any network or request errors here.
      console.error("Error:", error);
    }
  };

  render() {
    return (
      <div className="registration-form">
        <h2>Register User</h2>
        <form onSubmit={this.handleSubmit}>
          <div className="form-group">
            <label htmlFor="username">Username:</label>
            <input
              type="text"
              id="username"
              name="username"
              value={this.state.username}
              onChange={this.handleInputChange}
            />
          </div>
          <div className="form-group">
            <label htmlFor="email">Email:</label>
            <input
              type="email"
              id="email"
              name="email"
              value={this.state.email}
              onChange={this.handleInputChange}
            />
          </div>
          <div className="form-group">
            <label htmlFor="password">Password:</label>
            <input
              type="password"
              id="password"
              name="password"
              value={this.state.password}
              onChange={this.handleInputChange}
            />
          </div>
          <button type="submit">Register</button>
        </form>
      </div>
    );
  }
}

export default RegistrationForm;
