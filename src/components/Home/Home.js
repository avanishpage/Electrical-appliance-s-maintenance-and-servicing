import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';

import './Home.css'
const Home = () => {
  return (
    <div id='home-parentdiv'>
        <div className='home-childdiv'></div>
        <div className='home-childdiv'>
          <h1>Customer</h1>
          <Link to="/login-customer"><button>Customer SignUp</button></Link>

          <h1>Vender</h1>
          <Link to="/login-vendor"><button>Vender SignUp</button></Link>
        </div>
    </div>
  );
};

export default Home;
