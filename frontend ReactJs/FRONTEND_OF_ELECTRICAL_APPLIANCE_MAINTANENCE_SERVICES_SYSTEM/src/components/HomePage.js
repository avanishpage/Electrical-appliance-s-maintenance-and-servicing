import react from 'react';
import { Link } from 'react-router-dom';
import './css/HomePage.css'
import Header from './Header';
import Slider from './Slider'
function HomePage() {
    return (
        <div>
            <Header></Header>
            <div className="welcome-container">
                <h1 className="welcome-title">Welcome to ApplianceRevive Techs!</h1>
                <marquee>
                <p className="welcome-text">Your trusted experts in appliance repair and servicing</p>     
                </marquee>         
            </div>
            <Slider></Slider>
        </div>
    )
}
export default HomePage;