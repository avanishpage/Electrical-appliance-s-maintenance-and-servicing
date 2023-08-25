import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import './css/SignInPage.css'; 

function SignInPage() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    
    console.log('Sign in:', email, password);
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

export default SignInPage;
