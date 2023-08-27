import React, { useState } from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import HomePage from './components/HomePage';
import SignInPage from './components/SignInPage';
import SignInPageVendor from './components/SignInPageVendor';
import RegistrationPage from './components/RegistrationPage';
import RegistrationPageVendor from './components/RegistrationPageVendor';
import ForgotPasswordPage from './components/ForgotPasswordPage';
import AboutUsPage from './components/AboutUsPage';
import AboutImage from './components/AddImage';
import ContactUsPage from './components/ContactUsPage';
import AddImage from './components/AddImage';
import Sidebar from './components/Sidebar';
import GetOrders from './VenderPages/GetOrders';
import VenderDetails from './VenderPages/VenderDetails';
import UpdateServices from './VenderPages/UpdateServices';
import UpdateVenderDetails from './VenderPages/UpdateVenderDetails';
import VendorServices from './VenderPages/VendorServices';
import UpdateOrderStatus from './VenderPages/UpdateOrderStatus';
import AddService from './VenderPages/AddService';
import Logout from './VenderPages/Logout';
function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  return (
        <div>
        <Routes>
        <Route path="/" exact element={<HomePage />} />
        <Route path="/AboutUsPage" element={<AboutUsPage />} />
        <Route path="/ContactUsPage" element={<ContactUsPage />} />
        <Route path="/RegistrationPage" element={<RegistrationPage />} />
        <Route path="/RegistrationPageVendor" element={<RegistrationPageVendor />} />
        <Route path="/RegistrationPageVendor/AddImage" element={<AddImage />} />
        <Route path="/SignInPage" element={<SignInPage />} />
        <Route path="/SignInPageVendor" element={<SignInPageVendor setIsLoggedIn={setIsLoggedIn} />} />
        <Route path="/ForgotPasswordPage" element={<ForgotPasswordPage />} />
        </Routes>
        {isLoggedIn && ( 
          <Sidebar>
            <Routes>
              <Route path="/getorders" element={<GetOrders />} />
              <Route path="/vendor/:id" element={<VenderDetails />} />
              <Route path="/update/:id" element={<UpdateServices />} />
              <Route path="/addService" element={<AddService />} />
              <Route path="/updateOrderStatus" element={<UpdateOrderStatus />} />
              <Route path="/updatevendordetails" element={<UpdateVenderDetails />} />
              <Route path="/serviceDetails" element={<VendorServices />} />
              <Route path="/logout" element={<Logout setIsLoggedIn={setIsLoggedIn}/>} />
            </Routes>
          </Sidebar>
        )}
   </div>
  );
}

export default App;
