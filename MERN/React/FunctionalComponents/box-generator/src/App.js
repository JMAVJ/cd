import { useState } from 'react';
import './App.css';
import BoxForm from './components/BoxForm';
import Box from './components/Box';

function App() {
  const [boxes, setBoxes] = useState([]);
  return (
    <div className="App">
      <BoxForm boxes={boxes} setBoxes={setBoxes} />
      <div className="flex-container">
        {boxes.map((box, index) => (
          <Box key={index} {...box} />
        ))}
      </div>
    </div>
  );
}

export default App;
