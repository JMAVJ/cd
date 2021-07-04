import React, { useState } from 'react';
import axios from 'axios';

const Pokemon = () => {
  const [data, setData] = useState([]);

  const handleClick = () => {
    const API_URL = 'https://pokeapi.co/api/v2/pokemon?limit=807';
    axios
      .get(API_URL)
      .then(({ data: { results } }) => {
        setData(results);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <>
      <button onClick={() => handleClick()}>Fetch Pokemon</button>
      {data.map((pokemon, index) => (
        <h1 key={index}>{pokemon.name}</h1>
      ))}
    </>
  );
};

export default Pokemon;
