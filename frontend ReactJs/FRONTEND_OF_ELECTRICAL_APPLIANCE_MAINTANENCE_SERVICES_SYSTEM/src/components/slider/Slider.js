import React from "react";
import './Slider.css'
import { Carousel } from 'react-bootstrap';
function Slider() {
    return (

        <Carousel>
            <Carousel.Item>
                <img

                    className="d-block w-100"
                    src="../../images/air-conditioner-covid-19-1588000111.jpg"
                    alt="First slide"
                />
                <Carousel.Caption>
                    <h3>30% - 40% off</h3>
                    <p>You can always find something you want.</p>
                </Carousel.Caption>
            </Carousel.Item>

            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="../../images/phx401.jpg"
                    alt="Second slide"
                />
                <Carousel.Caption>
                    <h3>Up to 25% off</h3>
                    <p>I like my money right where I can see it: hanging in my closet.</p>
                </Carousel.Caption>
            </Carousel.Item>

            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="../../images/Refimages.jpeg"
                    alt="Third slide"
                />

            </Carousel.Item>
        </Carousel>

    )
}


export default Slider;