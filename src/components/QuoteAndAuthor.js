import React, { useState } from 'react'
import { quotesArray } from '../data'

function QuoteAndAuthor() {

    const { quote, setQuote} = useState(quotesArray[0].quote);
    const { author, setAuthor} = useState(quotesArray[0].author);
    const [randomNumber, setRandomNumber] = useState(0);

    // const getRandomQuote = () => {
    //     let randomInteger = Math.floor(quotesArray.length * Math.random())
    //     setRandomNumber(randomInteger)
    //     setQuote(quotesArray[randomInteger].quote)
    //     setAuthor(quotesArray[randomInteger].author)
    //     }
    
    return (
        <div className="card" >

            <div className="card-body">
                <p className="card-text">{quote}</p>
                <h5 className="card-title">-- {author}</h5>
                {/* <button
                    onClick={() => getRandomQuote ()}> Generate Quote</button> */}
            </div>
        </div>
    )
}
export default QuoteAndAuthor;