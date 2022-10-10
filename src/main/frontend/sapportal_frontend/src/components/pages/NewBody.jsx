import React from 'react';
import './NewBody.css'

const NewBody = () => {
    return (
        <div className='new-con'>
            <div className="left">
                <img src="images/SAP_logo.webp" alt="" />
            </div>
            <div className="right">
                <div className="forimg">

                <img className='san-img' src="images/mylogo.png"  alt="" />
                </div>
                <div className="content-right">
                    <h1 className='doit'>Sanjivani College Of Engneering</h1>
                </div>
            </div>
        </div>
    );
}

export default NewBody;
