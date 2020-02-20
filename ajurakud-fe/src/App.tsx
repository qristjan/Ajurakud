import React from 'react';
import logo from './logo.svg';
import './App.css';
import {NumberList} from "./NumberList";
import {MorphedBox} from "./MorphedBox";

function App() {
    return (
        <div className="App">
            <header className="App-header">
                <h1>Hello world</h1>
                <NumberList things={[1, 2, 3]}/>
                <MorphedBox/>
            </header>
        </div>
    );
}

export default App;
