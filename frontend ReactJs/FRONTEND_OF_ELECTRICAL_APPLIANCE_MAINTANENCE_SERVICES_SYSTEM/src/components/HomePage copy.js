import react from 'react';
import { Link } from 'react-router-dom';
import { Routes, Route } from 'react-router-dom';
import { Carousel } from 'react-bootstrap';
import './css/HomePage.css'
import Slider from 'react-slick';
import './Slider';
function HomePage() {
    return (
        <div>
            <Slider></Slider>
            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                <div class="container-fluid">
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">

                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="">
                                <a class="nav-link active" aria-current="page" href="#">Electric Aplliances</a>
                            </li>
                        </ul>
                        <div className='buttons'>
                            <ul>
                                <li class="nav-item">                                  
                                    <Link to="/">Home</Link>
                                </li>
                                <li class="nav-item">                                    
                                    <Link to="/AboutUsPage">About Us</Link>
                                </li>
                                <li class="nav-item">                                 
                                    <Link to="/ContactUsPage">Contact Us</Link>
                                </li>
                                <li class="nav-item">                                  
                                    <Link to="/SigninPage">SignIn/Register</Link>
                                </li>
                                <li class="nav-item">                                   
                                    <Link to="/RegistrationPageVendor">Register as vendor</Link>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </nav>
            
        </div>
    )
}
export default HomePage;