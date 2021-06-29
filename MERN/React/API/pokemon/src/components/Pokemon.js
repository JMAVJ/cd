import React, {useState} from 'react'

const Pokemon = () => {
  const [data, setData] = useState([])

  const handleClick = () => {
    const API_URL = 'https://pokeapi.co/api/v2/'
    fetch(API_URL + 'pokemon?limit=100')
      .then(res => res.json())
      .then(res => {setData(res.results)})
  }

  return (
    <>
      <button onClick={() => handleClick()}>Fetch Pokemon</button>
      {data.map((pokemon, index) => (
        <h1 key={index}>{pokemon.name}</h1>
      ))}
    </>
  )
}

export default Pokemon
