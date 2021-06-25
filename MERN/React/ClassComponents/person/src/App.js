import './App.css';
import PersonCard from './components/PersonCard';

function App() {
  return (
    <div className="App">
      <PersonCard firstName="firstname1" lastName="lastName1" age="20" hairColor="brown"  />
      <PersonCard firstName="firstname1" lastName="lastName1" age="20" hairColor="brown"  />
      <PersonCard firstName="firstname1" lastName="lastName1" age="20" hairColor="brown"  />
      <PersonCard firstName="firstname1" lastName="lastName1" age="20" hairColor="brown"  />
      <PersonCard firstName="firstname1" lastName="lastName1" age="20" hairColor="brown"  />
    </div>
  );
}

export default App;
