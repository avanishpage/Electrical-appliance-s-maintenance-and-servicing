import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import Header from './components/Header/Header';
import Home from './components/Home/Home';
function App() {
  return (
    <div className="App">
      <Router>
        <Header />
        <Routes>
          <Route path="/" element={<Home></Home>}></Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
