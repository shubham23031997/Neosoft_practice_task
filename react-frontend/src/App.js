import "./App.css";
import React from "react";
import { BrowserRouter as Router } from "react-router-dom";
import ListEmployeeComponent from "./component/ListEmployeeComponent";
import HeaderComponent from "./component/HeaderComponent";
import FooterComponent from "./component/FooterComponent";
//its root component
//react team recomended to use jsx becz its easy and clean
function App() {
  return (
    <div>
      <Router>
        <div className="container">
          <HeaderComponent />

          <div className="container">
            <ListEmployeeComponent></ListEmployeeComponent>
          </div>

          <FooterComponent />
        </div>
      </Router>
    </div>
  );
}

export default App;
