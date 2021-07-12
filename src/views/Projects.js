import React from "react";
import ctgr from '../images/ctgr.png';


export default function Projects() {

    return(
            <div className="container">
                <h2>Projects</h2>
                <div class="row">
                    <figure id="fig1">
                        <div class="col">
                        Confederated Tribes of Grand Ronde 
                        <img src={ctgr}/>
                        </div>
                    </figure>

                    <figure id="fig2">
                    <div class="col">
                    Project 2 
                    </div>
                    </figure>
                </div>
                </div>
    );
}