import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './css/SignInPage.css'; 
import axios from 'axios';
function SignInPageVendor({setIsLoggedIn}) {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();
  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  // const handleSubmit = (e) => {
  //   e.preventDefault();
    
  //   console.log('Sign in:', email, password);
  // };
  const handleSubmit = (e) => {
    e.preventDefault();

    // Send a request to the backend to check if the user exists
    axios.post('http://localhost:8080/vendor/login', {
      email:email,
      password:password,
    })
    .then(response => {
      if (!response.data.exists) {
        // User exists, navigate to UserDetailsPage
        localStorage.setItem('vendor',JSON.stringify(response.data))
        setIsLoggedIn(true);
        navigate('/getorders')
      } else {
        // User doesn't exist, display an error or handle accordingly
        console.log('User does not exist',{ email, password });
      }
    })
    .catch(error => {
      console.error('Error checking user:', error);
    });
  };


  return (
    <div className="sign-in-page">
      <div className="sign-in-container">
        <h2>Sign In</h2>
        <form onSubmit={handleSubmit}>
          <label htmlFor="email">Email<span> *</span></label>
          <input
            type="email"
            id="email"
            value={email}
            onChange={handleEmailChange}
            placeholder="Enter your email"
            required
          />

          <label htmlFor="password">Password<span> *</span></label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={handlePasswordChange}
            placeholder="Enter your password"
            required
          />

          <div>
          <button type="submit">Sign In</button>
          <Link to="/ForgotPasswordPage">Forgot Password?</Link>
          </div>
          <p>
          Don't have an account? <Link to="/RegistrationPage">Register here</Link>
        </p>
        </form>
      </div>
     
    </div>
  );
}

export default SignInPageVendor;
