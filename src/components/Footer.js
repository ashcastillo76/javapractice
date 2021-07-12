import React from 'react'
import facebook from '../images/facebook.png';
import instagram from '../images/instagram.png';
import email from '../images/email.png';
import { BrowserRouter as Router, Link } from 'react-router-dom';

const footer = () => {
    return (
        <div className="footer">
            <Router>
                <div className="footImgContainer">
                    <Link to="https://www.facebook.com/ashley.castillo76/"><img src={ facebook }/></Link>
                    <Link to="https://www.instagram.com/hecallsmesassypants/"><img src={ instagram }/></Link>
                    <a href="mailto:ashcastillo76@gmail.com"><img src={ email }/></a>
                </div>
            </Router>
        </div>
    )
}

export default footer
