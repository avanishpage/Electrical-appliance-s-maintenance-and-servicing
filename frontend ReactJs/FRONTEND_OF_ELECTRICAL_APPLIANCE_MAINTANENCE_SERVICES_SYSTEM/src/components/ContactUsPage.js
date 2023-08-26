import React from 'react';
import { Link } from 'react-router-dom';
import './css/ContactUsPage.css'; 
const ContactUsPage = () => {
  return (
    <div className="help-container">
      <h2>Need Help?</h2>
      <p>If you are experiencing any issues or have questions, we are here to assist you.</p>
      <p>Please feel free to contact our support team:</p>
      <div className="contact-details">
        <p>Email: support@example.com</p>
        <p>Phone: 123-456-7890</p>
      </div>
      <Link to="/">Go to Home</Link>
    </div>
    
  );
};

export default ContactUsPage;
