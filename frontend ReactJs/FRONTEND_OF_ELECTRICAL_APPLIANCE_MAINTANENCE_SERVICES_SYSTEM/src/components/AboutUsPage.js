import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import './css/AboutUsPage.css';
const AboutUsPage = () => {
  return (
    <div className="about-us-container">
      <h2>About Us</h2>
      <p>Welcome to our website! We are dedicated to providing top-notch services...</p>
      <p>At our company, we specialize in electrical appliances services and maintenance...</p>
      <p>Our team of experts is committed to ensuring that your appliances...</p>
      <p>With years of experience in the industry, we have earned a reputation...</p>
      <p>Feel free to explore our website and learn more about our services...</p>
      <Link to="/">Go to Home</Link>
    </div>
  );
};

export default AboutUsPage;
