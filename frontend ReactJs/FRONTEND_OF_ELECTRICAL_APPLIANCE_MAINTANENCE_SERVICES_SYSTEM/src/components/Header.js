import './css/Header.css'
import React from 'react';
import { Link } from 'react-router-dom';

function Header() {
    return (
        <header>
            <nav>
                <div className="nav-left">
                    <a href="/" className="company-name">ApplianceReviveTechs</a>
                </div>
                <div className="nav-right">
                    <ul>
                        <li class="nav-item">
                            <Link to="/">Home</Link>
                        </li>
                        <li class="nav-item">
                            <Link to="/AboutUsPage">About</Link>
                        </li>
                        <li class="nav-item">
                            <Link to="/ContactUsPage">ContactUs</Link>
                        </li>
                        <li class="nav-item">
                            <Link to="/SignInPage">Log In</Link>
                        </li>
                        <li class="nav-item">
                            <Link to="/RegistrationPage">Register</Link>
                        </li>
                        <li class="nav-item">
                            <Link to="/SignInPageVendor">Log In as vendor</Link>
                        </li>
                        
                    </ul>
                </div>
            </nav>
        </header>
    );
}

export default Header;
