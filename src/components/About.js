export default function About() {
return(
    <section id ="about">
        <div id="mainBody">
            
            <div id="name">
                <h2>Hi! I'm Ashley.</h2>
                    <p>"A programmer is a person who fixes a problem you don't know you have in a way that you don't understand."  -via HongKiat</p>
            </div>
        </div>
        <div id="about">
            <div class="row justify-content-center">
                <div class="col-4">
                    <div id="picBox">
                        <img src="static/images/Headshot.JPEG"/>
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
                    <img src="./static/images/honeymoon.jpg" class="d-block w-100" alt="banffBeauty"/>
                </div>
                <div class="carousel-item">
                    <img src="./static/images/Jude.JPEG" class="d-block w-100" alt="..."/>
                </div>
                <div class="carousel-item">
                    <img src="./static/images/headshot_light.jpg" class="d-block w-100" alt="..."/>
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