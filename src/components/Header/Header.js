import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import './Header.css'

const Header = () => {
  return (
    <>
    
      
        <h1 id="app-name">Electrical Appliance's Maintenance and Services</h1>
        <nav id="nav-bar">
        <ul>
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/services">Services</Link>
            </li>
            <li>
              <Link to="/about">About</Link>
            </li>
            <li>
              <Link to="/contact">Contact</Link>
            </li>
            
        </ul>
        </nav>
      
    </>
  );
};

export default Header;
