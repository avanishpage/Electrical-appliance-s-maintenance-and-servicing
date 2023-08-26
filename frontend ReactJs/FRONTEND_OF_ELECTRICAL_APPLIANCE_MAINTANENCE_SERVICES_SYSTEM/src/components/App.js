import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import SignInPage from './components/SignInPage';
import SignInPageVendor from './components/SignInPageVendor';
import RegistrationPage from './components/RegistrationPage';
import RegistrationPageVendor from './components/RegistrationPageVendor';
import ForgotPasswordPage from './components/ForgotPasswordPage';
import AboutUsPage from './components/AboutUsPage';
import ContactUsPage from './components/ContactUsPage';
import Categories from './components/Categories';
import Slider from './components/Slider';
import NavigationBar from './components/NavigationBar';
import MyAccount from './components/MyAccount';
import MyOrders from './components/MyOrders';
import HomePage from './components/HomePage';
import ServicesList from './components/ServiceList';
import './components/NavigationBar.css';
import './components/Categories.css';
import './components/ServiceList.css'

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" exact element={<HomePage />} />
        {/* <Route path="/"  element={<Slider />} /> */}
        <Route path="/AboutUsPage" element={<AboutUsPage />} />
        <Route path="/ContactUsPage" element={<ContactUsPage />} />
        <Route path="/RegistrationPage" element={<RegistrationPage />} />
        <Route path="/RegistrationPageVendor" element={<RegistrationPageVendor />} />
        <Route path="/SignInPage" element={<SignInPage />} />
        <Route path="/SignInPageVendor" element={<SignInPageVendor />} />
        <Route path="/ForgotPasswordPage" element={<ForgotPasswordPage />} />

        <Route path="/Categories" element={<Categories />} />
        <Route path="/my-account" element={<MyAccount />} />
        <Route path="/my-orders" element={<MyOrders />} />
        {/* <Route path="/" exact element={<NavigationBar/>} /> */}
        <Route path="/:category/service" element={<ServicesList />} />

        {/* Other routes */}
      </Routes>
    </Router>
  );
}

export default App;
