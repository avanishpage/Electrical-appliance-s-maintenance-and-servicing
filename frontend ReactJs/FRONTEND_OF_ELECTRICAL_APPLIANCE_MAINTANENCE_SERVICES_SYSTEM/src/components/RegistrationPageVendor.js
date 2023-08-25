import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import './css/RegistrationPage.css';
function RegistrationPageVendor() {
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    flatNo: '',
    area: '',
    city: '',
    district: '',
    state: '',
    country: '',
    pincode: '',
    phoneNumber: '',
    password: '',
    confirmPassword: '',
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(formData);
    
    for (const key in formData) {
      if (formData[key].trim() === '') {
        alert(`${key} is required.`);
        return;
      }
    }

    if (!/^\d{6}$/.test(formData.pincode)) {
      alert('Pincode must be 6 digits.');
      return;
    }

    if (!/^\d{10}$/.test(formData.phoneNumber)) {
      alert('Phone number must be 10 digits.');
      return;
    }
    if (formData.password !== formData.confirmPassword) {
      alert('Password and Confirm Password do not match.');
      return;
    }
  };

  return (
    <div className="registration-form">
      <h2>Register Vendor</h2>
      <form onSubmit={handleSubmit}>

        <label htmlFor="firstName">First Name <span> *</span></label>
        <input
          type="text"
          id="firstName"
          name="firstName"
          value={formData.firstName}
          onChange={handleInputChange}
          placeholder="Enter your first name"
          required
        />

        <label htmlFor="lastName">Last Name <span> *</span></label>
        <input
          type="text"
          id="lastName"
          name="lastName"
          value={formData.lastName}
          onChange={handleInputChange}
          placeholder="Enter your last name"
          required
        />



        <label htmlFor="email">Email <span> *</span></label>
        <input
          type="email"
          id="email"
          name="email"
          value={formData.email}
          onChange={handleInputChange}
          required
          placeholder="Enter your email"
        />
        <label htmlFor="password">Password <span>*</span></label>
        <input
          type="password"
          id="password"
          name="password"
          value={formData.password}
          onChange={handleInputChange}
          placeholder="Enter your password"
          required
        />


        <label htmlFor="confirmPassword">Confirm Password <span>*</span></label>
        <input
          type="password"
          id="confirmPassword"
          name="confirmPassword"
          value={formData.confirmPassword}
          onChange={handleInputChange}
          placeholder="Confirm your password"
          required
        />
        <label htmlFor="adderss">Adderss:</label>
        <label htmlFor="flatNo">Shop No. <span> *</span></label>
        <input
          type="text"
          id="flatNo"
          name="flatNo"
          value={formData.flatNo}
          onChange={handleInputChange}
          placeholder="Enter your FlatNo/HouseNo"
          required
        />

        <label htmlFor="area">Area <span> *</span></label>
        <input
          type="text"
          id="area"
          name="area"
          value={formData.area}
          onChange={handleInputChange}
          placeholder="Enter your Area"
          required
        />

        <label htmlFor="country">Country <span> *</span></label>
        <select
          id="country"
          name="country"
          value={formData.country}
          onChange={handleInputChange}
          required
        >
          <option value="" disabled>Select Country</option>
          <option value="country1">India</option>
        </select>

        <label htmlFor="state">State <span> *</span></label>
        <select
          id="state"
          name="state"
          value={formData.state}
          onChange={handleInputChange}
          required
        >
          <option value="" disabled>Select State</option>
          <option value="state1">Maharashtra</option>
          <option value="state2">Karnataka</option>
          <option value="state3">Telangana</option>
        </select>

        <label htmlFor="district">District <span> *</span></label>
        <select
          id="district"
          name="district"
          value={formData.district}
          onChange={handleInputChange}
          required
        >
          <option value="" disabled>Select District</option>
          <option value="district1">Pune</option>
          <option value="district2">Mumbai</option>
          <option value="district3">Nashik</option>
          <option value="district4">Nagpur</option>
          <option value="district5">Bangalore Urban District</option>
          <option value="district6">Hyderabad District</option>
        </select>



        <label htmlFor="city">City <span> *</span></label>
        <select
          id="city"
          name="city"
          value={formData.city}
          onChange={handleInputChange}
          required
        >
          <option value="" disabled>Select City</option>
          <option value="city1">Pune</option>
          <option value="city2">Pimpri-Chinchwad</option>
          <option value="city3">Bandra</option>
          <option value="city4">Juhu</option>
          <option value="city5">Sinnar</option>
          <option value="city5">Nagpur</option>
          <option value="city5">Bangalore city</option>
          <option value="city6">Hyderabad</option>
        </select>



        <label htmlFor="pincode">Pincode <span> *</span></label>
        <input
          type="text"
          id="pincode"
          name="pincode"
          value={formData.pincode}
          onChange={handleInputChange}
          placeholder="Enter your pincode"
          required
        />

        <label htmlFor="phoneNumber">Phone Number <span> *</span></label>
        <input
          type="tel"
          id="phoneNumber"
          name="phoneNumber"
          value={formData.phoneNumber}
          onChange={handleInputChange}
          placeholder="Enter your phone no."
          required
        />


        <button type="submit">Register</button>
        <p>
          Already registered? <Link to="/SignInPageVendor">Login here</Link>
        </p>
      </form>

    </div>
  );
}

export default RegistrationPageVendor;
