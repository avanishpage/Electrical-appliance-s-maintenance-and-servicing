import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
// import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import HomePage from './Home/HomePage';
import RegisterCustomer from './Home/RegisterCustomer'
import CustomerLogin from './Home/CustomerLogin'
import NavigationBar from './Customer/NavigationBar';
import Categories from './Customer/Categories';
import MyAccount from './Customer/MyAccount';
import MyOrders from './Customer/MyOrders';
import Cart from './Customer/Cart';
import ServicesList from './Customer/ServiceList';
import './Customer/NavigationBar.css';
import './Customer/Categories.css';
import './Customer/ServiceList.css';

function App() {

  // const navigate = useNavigate();
  // useEffect(() => {
  //   const storedUserData = JSON.parse(localStorage.getItem('userData'));

  //   if (storedUserData) {
  //     // User data found, navigate to categories page
  //     navigate('/categories');
  //   }
  // }, [navigate]);

  return (
    <Router>
      <div className="App">
        {/* <NavigationBar /> */}
        <Routes>
          <Route path="/" exact element={<HomePage/>} />
          <Route path="/register/customer" element={<RegisterCustomer/>} />
          <Route path="/login/customer" element={<CustomerLogin/>} />
          {/* <Route path="/vendor-login" element={<VendorSignIn/>} />  */}
          <Route path="/customer/categories" exact element={<Categories/>} />
          <Route path="/my-account" element={<MyAccount/>} />
          <Route path="/my-orders" element={<MyOrders/>} />
          <Route path="/cart" element={<Cart/>} />
          <Route path="/customer/categories/:category/service" element={<ServicesList/>} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
