import React from "react";
import { NavLink } from 'react-router-dom';

export default function Navbar() {
    return(

        <div className="header">
                <h1><NavLink to="/">Ashley Castillo</NavLink></h1>
                <div className="nav">
                    <ul>
                        <li><NavLink to="/about">About</NavLink></li>
                        <li><NavLink to= "/resume">Resume</NavLink></li>
                        <li><NavLink to="/projects">Projects</NavLink></li>
                        <li><NavLink to="/skills">Skills</NavLink></li>
                        <li><NavLink to="/contact">Contact</NavLink></li>
                    </ul>
                </div>
            </div>
    );
}