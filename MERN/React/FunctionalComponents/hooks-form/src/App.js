import { useState } from 'react';
import './App.css';
import RegisterForm from './components/RegisterForm';
import UserData from './components/UserData';

function App() {
  const [user, setUser] = useState({});

  return (
    <div className="App">
      <RegisterForm user={user} setUser={setUser} />
      <UserData {...user} />
    </div>
  );
}

export default App;
