import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import NavigationBar from './Customer/NavigationBar';
import Categories from './Customer/Categories';
import MyAccount from './Customer/MyAccount';
import MyOrders from './Customer/MyOrders';
import Cart from './Customer/Cart';
import ServicesList from './Customer/ServiceList';
import './Customer/NavigationBar.css';
import './Customer/Categories.css';
import './Customer/ServiceList.css'

function App() {
  return (
    <Router>
      <div className="App">
        <NavigationBar />
        <Routes>
          <Route path="/" exact element={<Categories/>} />
          <Route path="/my-account" element={<MyAccount/>} />
          <Route path="/my-orders" element={<MyOrders/>} />
          <Route path="/cart" element={<Cart/>} />
          <Route path="/:category/service" element={<ServicesList/>} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
