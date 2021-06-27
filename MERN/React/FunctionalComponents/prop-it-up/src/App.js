import './App.css';
import PersonCard from './components/PersonCard';

function App() {
  const data = [
    {
      firstName: "Jane",
      lastName: "Doe",
      age: 45,
      hairColor: "Black",
    },
    {
      firstName: "John",
      lastName: "Smith",
      age: 88,
      hairColor: "Brown",
    },
    {
      firstName: "Millard",
      lastName: "Fillmore",
      age: 50,
      hairColor: "Brown",
    },
    {
      firstName: "Maria",
      lastName: "Smith",
      age: 62,
      hairColor: "Brown",
    },
  ]
  return (
    <div className="App">
      {data.map((person, index) => (
        <PersonCard key={index} {...person}/>
      ))}
    </div>
  );
}

export default App;
