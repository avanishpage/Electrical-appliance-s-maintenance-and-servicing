import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import HomePage from './components/HomePage';
import Slider from './components/Slider';
function App() {
  return (
   

      

      
        <Routes>
        <Route path="/" exact element={<HomePage />} />
        </Routes>
      
   
  );
}

export default App;
