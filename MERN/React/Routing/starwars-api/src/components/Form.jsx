import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { capitalize } from '../utils';

const Form = ({ setResource, onSubmit, setId }) => {
  const [availableResources, setAvailableResources] = useState([]);

  useEffect(() => {
    const url = 'https://swapi.dev/api/';
    axios.get(url).then(({ data: res }) => {
      setAvailableResources(Object.keys(res));
    });
  }, []);

  const handleResourceChange = ({ target: { value } }) => {
    setResource(value);
  };

  const handleIdChange = ({ target: { value } }) => {
    setId(value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit();
  };

  return (
    <form onSubmit={handleSubmit}>
      <select onChange={handleResourceChange} defaultValue="people">
        {availableResources.map((resource) => (
          <option value={resource}>{capitalize(resource)}</option>
        ))}
      </select>
      <input type="number" placeholder="ID" onChange={handleIdChange} />
      <input type="submit" value="Search" />
    </form>
  );
};

export default Form;
