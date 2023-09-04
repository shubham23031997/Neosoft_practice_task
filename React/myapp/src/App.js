import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Register from "./compontents/Register";
import Login from "./compontents/Login";

import Home from "./compontents/Home";
const App = () => {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/home" element={<Home />} />
          <Route path="/register" element={<Register />} />
          <Route path="/" element={<Login />} />
        </Routes>
      </BrowserRouter>
    </div>
    //  <React.Fragment>
    //   <h1>welcome</h1>
    // </React.Fragment>
  );
};
// jsx
//is always return a single element
//every tag have to close in jsx
export default App;
