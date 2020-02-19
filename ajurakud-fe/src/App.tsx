import React from 'react';
import logo from './logo.svg';
import './App.css';
import {NumberList} from "./NumberList";

function App() {
    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <p>o
                    <NumberList things={[1, 2, 3]}/>
                </p>
            </header>
        </div>
    );
}

export default App;
