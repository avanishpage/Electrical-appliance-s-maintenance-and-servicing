import React from 'react';
import { Link } from 'react-router-dom';
import './css/ContactUsPage.css'; 
import Header from './Header';
import Footer from './Footer';
const ContactUsPage = () => {
  return (
    <div  className='form'>
      <Header></Header>
      <p></p>
    <div className="help-container">
      <h2>Need Help?</h2>
      <p>If you are experiencing any issues or have questions, we are here to assist you.</p>
      <p>Please feel free to contact our support team:</p>
      <div className="contact-details">
        <p>Email: appliancerevivetechs@gmail.com</p>
        <p>Phone: +91 9864785365</p>
        <p>Address: ShivajiNagar, Pune, India</p>
      </div>
      <Link to="/">Go to Home</Link>
    </div>
    <p></p>
    <Footer></Footer>
    </div>
  );
};

export default ContactUsPage;
