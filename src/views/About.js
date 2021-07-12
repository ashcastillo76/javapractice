import React from "react";
import Headshot from '../images/Headshot.JPEG';
import ControlledCarousel from '../components/ControlledCarousel';

export default function About() {
return(
    <>
        <div className="about">
            <div class="row justify-content-center">
                <div class="col-4">
                    <div className="picBox">
                        <img src={Headshot}/>
                    </div>
                </div>
                <div class="col-4">
                    <h1>About Me</h1>
                    <p>My name is Ashley and I am a Software Engineer based in Spokane, WA.</p>
                </div>
            </div>
        </div>
        <div className="aboutMe2Wrap">
    <div className="leftAbout">
            <h1>Why Work With Me</h1>
            <p>more information that I will fill in all kinds of awesome facts</p>
    </div>
        
    <div className="carouselContainer">
        <ControlledCarousel/>
    </div>
</div>
</>
);

}