import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./layout/Navbar";
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Orders from './users/OrderForm';

function App() {
  return (
    <div className="App">
      <Router>
      <Navbar/>
      <Routes>
        <Route exact path="/" element={<Orders/>}/>     
      </Routes>
      </Router>
    </div>
  );
}

export default App;
