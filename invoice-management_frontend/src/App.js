import logo from './logo.svg';
import './App.css';
import CustomersList from './components/CustomersList';
import Header from './components/Header';
import Footer from './components/Footer';

function App() {
  return (
    
 
    <div className="container-fluid h-100">
      <Header />
        <CustomersList />
      <Footer/>
    </div>
   
  );
}

export default App;
