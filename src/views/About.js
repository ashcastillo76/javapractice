import React from "react";
import Headshot from '../images/Headshot.JPEG';
import boys_cool from '../images/boys_cool.jpg';
import headshot_light from '../images/headshot_light.jpg';
import honeymoon from '../images/honeymoon.jpg';



export default function About() {
return(
    <section id ="about">
       
        <div id="about">
            <div class="row justify-content-center">
                <div class="col-4">
                    <div id="picBox">
                        <img src={Headshot}/>
                    </div>
                </div>
                <div class="col-4">
                    <h1>About Me</h1>
                    <p>My name is Ashley and I am a Software Engineer based in Spokane, WA.</p>
                </div>
            </div>
        </div>
        <div id="aboutMe2Wrap">
    <div id="leftAbout">
            <h1>Why Work With Me</h1>
            <p>more information that I will fill in all kinds of awesome facts</p>
    </div>
        
    <div id="carouselontainer">
        <div id="carouselExampleControlsNoTouching" class="carousel slide" data-bs-touch="false" data-bs-interval="false">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src={honeymoon} class="d-block w-100" alt="banffBeauty"/>
                </div>
                <div class="carousel-item">
                    <img src={boys_cool} class="d-block w-100" alt="..."/>
                </div>
                <div class="carousel-item">
                    <img src={headshot_light} class="d-block w-100" alt="..."/>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>
</div>
</section>
);

}