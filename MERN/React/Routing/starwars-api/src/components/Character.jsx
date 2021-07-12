import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { capitalize } from '../utils';

const Character = ({
  match: {
    params: { id },
  },
}) => {
  const [data, setData] = useState({});

  useEffect(() => {
    const url = `https://swapi.dev/api/people/${id}`;
    axios
      .get(url)
      .then((res) => {
        setData(res.data);
      })
      .catch((res) => {
        console.log(res);
      });
  }, [id]);

  return (
    <div>
      <h4>{data.name}</h4>
      <ul>
        {Object.keys(data)
          .splice(1, 4)
          .map((key) => (
            <li>
              {capitalize(key)}: {data[key]}
            </li>
          ))}
      </ul>
    </div>
  );
};

export default Character;
