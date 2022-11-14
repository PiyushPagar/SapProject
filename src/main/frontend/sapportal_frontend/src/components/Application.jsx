import React from 'react';
import "./Application.css"
import Footer from './pages/Footer';
import Navbarforapp from './pages/Navbarforapp';

const Application = () => {
    return (
        <div>
            <Navbarforapp/>
            <div className="app-con">
                <div className="app-con-from">
                    <h1 className='center '>SAP APPLICATION</h1>
                    <div className='app-content'>
                        <input type="text" placeholder='Enter your name' />
                        <input type="text" placeholder='Enter your name' />
                       
                     
                    </div>
                    <div className='app-content'>
                        <input type="text" placeholder='Enter your name' />
                        <input type="text" placeholder='Enter your name' />
                       
                     
                    </div>
                    <div className='app-content'>
                        <input type="text" placeholder='Enter your name' />
                        <input type="text" placeholder='Enter your name' />
                       
                     
                    </div>
                    <div className='app-content'>
                        <input type="text" placeholder='Enter your name' />
                        <input type="text" placeholder='Enter your name' />
                       
                     
                    </div>
                    <div className='app-content'>
                        <input type="text" placeholder='Enter your name' />
                        <input type="text" placeholder='Enter your name' />
                       
                     
                    </div>
                    
                    <button className='btn-app'>Submit</button>
                </div>
            </div>
            <Footer/>
        </div>
    );
}

export default Application;
