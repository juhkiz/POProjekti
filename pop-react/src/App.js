import './App.css';
import React from 'react';
import SportsSummary from './Components/SportsSummary';
import FoodsSummary from './Components/FoodsSummary';

function App() {
  return (
    <div className="App">
      <SportsSummary />
      <FoodsSummary />
    </div>
  );
}

export default App;
