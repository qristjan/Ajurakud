import React from 'react';
import logo from './logo.svg';
import './App.css';

function App() {
  let x: String = "ajurakud.d.ts";
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          {x}
        </p>
      </header>
    </div>
  );
}

export default App;
