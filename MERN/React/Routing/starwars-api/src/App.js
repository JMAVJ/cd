import React, { useState } from 'react';
import axios from 'axios';

import Form from './components/Form';
import Data from './components/Data';

import './App.css';

function App() {
  const [resource, setResource] = useState('people');
  const [id, setId] = useState(1);
  const [data, setData] = useState({});
  const [error, setError] = useState(false);

  const handleSubmit = () => {
    const url = `https://swapi.dev/api/${resource}/${id}/`;
    axios
      .get(url)
      .then((res) => {
        setData(res.data);
        setError(false);
      })
      .catch(() => {
        setError(true);
      });
  };

  return (
    <div className="App">
      <h1>Star Wars API</h1>
      <Form setResource={setResource} setId={setId} onSubmit={handleSubmit} />
      {error ? <p>There was an error</p> : <Data data={data} />}
    </div>
  );
}

export default App;
