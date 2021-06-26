import './App.css';
import PersonCard from './components/PersonCard';

function App() {
  return (
    <div className="App">
      <PersonCard firstName="person1" lastName="asdfadsf" age={20} hairColor="brown"  />
      <PersonCard firstName="person2" lastName="lastName1" age={25} hairColor="brown"  />
    </div>
  );
}

export default App;
