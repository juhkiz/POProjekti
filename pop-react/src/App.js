import './App.css';
import React from 'react';
import { BrowserRouter, Route, Switch } from "react-router-dom";
import SportsSummary from './Components/SportsSummary';
import FoodsSummary from './Components/FoodsSummary';
import FrontPage from './Components/FrontPage';
import ButtonAppBar from './Components/ButtonAppBar';

function App() {
  return (
    <BrowserRouter>
    <ButtonAppBar/>
           <Switch> 
               <Route exact path='/'> <FrontPage /> </Route>
               <Route path='/foods'> <FoodsSummary /></Route>
               <Route path='/sports'> <SportsSummary /> </Route>
               </Switch>
       </BrowserRouter>
 );
}

export default App;
