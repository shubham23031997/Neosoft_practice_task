import "./App.css";
import React from "react";
import { Routes, Route } from "react-router-dom";
import { BrowserRouter as Router } from "react-router-dom";
import ListEmployeeComponent from "./component/ListEmployeeComponent";
import HeaderComponent from "./component/HeaderComponent";
import FooterComponent from "./component/FooterComponent";
import CreateEmployeeComponent from "./component/CreateEmployeeComponent";
import UpdateEmployeeComponent from "./component/UpdateEmployeeComponent";
//its root component
//react team recomended to use jsx becz its easy and clean
function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className="container">
          <Routes>
            <Route path="/" element={<ListEmployeeComponent />} />
            <Route path="/employees" element={ListEmployeeComponent}></Route>
            <Route
              path="/add-employee"
              element={<CreateEmployeeComponent />}
            ></Route>
            <Route
              path="/update-employee/:id}"
              element={<UpdateEmployeeComponent />}
            ></Route>
          </Routes>
        </div>
        <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
// import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

// <Switch>
//     <Route path="/home" component={Home} />
// </Switch>
// New Syntax:

// import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

// <Routes>
//     <Route path="/home" element={<Home/>} />
// </Routes>
